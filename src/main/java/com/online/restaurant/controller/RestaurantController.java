package com.online.restaurant.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.online.restaurant.Repo.AdminRepo;
import com.online.restaurant.Repo.CategoryRepo;
import com.online.restaurant.Repo.ConfirmOrderRepo;
import com.online.restaurant.Repo.FeedbackRepo;
import com.online.restaurant.Repo.FoodCounterRepo;
import com.online.restaurant.Repo.FoodRepo;
import com.online.restaurant.Repo.OlderOrderRepo;
import com.online.restaurant.Repo.OrderRepo;
import com.online.restaurant.Repo.RecipeRepo;
import com.online.restaurant.Repo.RestaurantRepo;
import com.online.restaurant.domain.Admin;
import com.online.restaurant.domain.Category;
import com.online.restaurant.domain.Feedback;
import com.online.restaurant.domain.Food;
import com.online.restaurant.domain.FoodCounter;
import com.online.restaurant.domain.Login;
import com.online.restaurant.domain.OlderOrderTable;
import com.online.restaurant.domain.Ordertable;
import com.online.restaurant.domain.Recipe;
import com.online.restaurant.domain.Registration;
import com.online.restaurant.services.ServiceClass;

@Controller
public class RestaurantController {
	@Autowired
	RestaurantRepo repo;
	@Autowired
	FoodRepo foodRepo;
	@Autowired
	RecipeRepo reciperepo;
	@Autowired
	private AdminRepo adminrepo;
	@Autowired
	private OrderRepo orderrepo;
	@Autowired
	private ConfirmOrderRepo confirmorderrepo;
	@Autowired
	private FeedbackRepo feedrepo;
	@Autowired
	private OlderOrderRepo olderorderrepo;
	@Autowired
	private CategoryRepo catrepo;
	@Autowired
	private FoodCounterRepo foodcntrepo;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	Ordertable orderObjOrdertable;
	private Admin admin = new Admin();
	private Food food;
	private String getUSer;
	private String pass;
	private String loginuserString = "";
//	ConfirmOrder confirm = new ConfirmOrder();
	int i = 0;
	@Autowired
	ServiceClass serviceclass;
//---------------------------------------------------------index-------------------------------------------------------	

	@GetMapping({ "/", "/index" })
	public String Home() {
		return "views/index";
	}

//----------------------------------------------Registration / Login------------------------------------------------------



	@GetMapping("/account")
	public String account() {
		return "views/account";
	}
	/*
	@PostMapping(value = "/account")
	public String registration(Registration account) {
		Registration reg = null;
		System.out.println(account);
		reg = repo.fetchByEmail(account.getEmail());
		if (reg == null) {
			repo.save(account);
			return "views/account";
		}
		
		else {
			
			return "views/RegistrationFailure";
		}	
	}
*/

	// -------------------------------------------------------------------------------------------------
	
	@GetMapping("/register")
	public String register() {
		return "views/register";
	}
	
	
	@PostMapping(value = "/register")
	public String registreration(Registration account) {
		Registration reg = null;
		System.out.println(account);
		reg = repo.fetchByEmail(account.getEmail());
		if (reg == null) {
			repo.save(account);
			
			return "views/account";
		}
		else {
			
			return "views/RegistrationFailure";
		}
		
	}
	
	// -------------------------------------------------------------------------------------------------
	
	
	@PostMapping(value = "/success")
	public String login(HttpSession session, Login login) {
	try {
		
		if (login.getEmail().equals(repo.findById(login.getEmail()).get().getEmail())
				&& login.getPassword().equals(repo.findById(login.getEmail()).get().getPassword())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalTime localTime = LocalTime.now();

			session.setAttribute("user", login.getEmail());
			session.setAttribute("logtime", dtf.format(localTime));
			
			System.out.println(repo.findById(login.getEmail()).get().getEmail());
			System.out.println(repo.findById(login.getEmail()).get().getPassword());
			
			

			return "views/success";
		}
		else {
			session.invalidate();
			return "views/loginfail";
		}
		
		} catch (Exception e) {
			session.invalidate();
			return  "views/loginfail";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "views/index";
	}

//----------------------------------------------------------------------------------------------------------------------------

// FoodManu dynamic

	@GetMapping("/foodmenu")
	public String foodMenu(Model map) {
		List<Food> food = (List<Food>) foodRepo.findAll();

		map.addAttribute("food", food);

		return "views/foodmenu";

	}

	@GetMapping("/showfood/{name}")
	@ResponseBody
	public void showImage(@PathVariable("name") String name, HttpServletResponse response, Optional<Food> food)
			throws ServletException, IOException {
		food = foodRepo.findById(name);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(food.get().getPhoto());
		response.getOutputStream().close();

	}

	@GetMapping("/addRecipe")
	public String ownRecpSet(Model model, HttpSession session) {

		model.addAttribute("recipe", reciperepo.findAll());
		return "views/addRecipe";
	}

	@PostMapping(value = "/save")
	public String ownRecpGet(Model model, Recipe s) {
		System.out.println(s);
		reciperepo.save(s);
		model.addAttribute("recipe", reciperepo.findAll());
		flag = flag + 1;
		return "views/addRecipe";

	}

	@PostMapping(value = "/feedback")
	public String saveFeedback(@RequestParam("rating") Integer rating, @RequestParam("feedtext") String feed,
			Model model, HttpSession session, Feedback feedback) {

		model.addAttribute("orderid", (Integer) session.getAttribute("orderid"));
		model.addAttribute("username", (String) session.getAttribute("user"));
		
		
	
		System.out.println((Integer) session.getAttribute("orderid"));	
		System.out.println((String) session.getAttribute("user"));	
	
		
		feedback.setUsername((String) session.getAttribute("user"));
		feedback.setRating(rating);
		feedback.setFeedback((String) feed);
		feedrepo.save(feedback);

		return "views/index";
	}

	int flag = 0;

	Ordertable ordertableOBJ = new Ordertable();
	Date date = new Date();
	String statuString;
	LocalDateTime currentTime = LocalDateTime.now();

	@GetMapping("/saveorder")
	public String getOrder(HttpSession session, @RequestParam(name = "fooditems", required = false) String foodlist,
			@RequestParam(name = "total", required = false) int totalprice,
			@RequestParam(name = "user", required = false) String username,
			@RequestParam(name = "breakfast", required = false) ArrayList<String> breakfast,
			@RequestParam(name = "veg", required = false) ArrayList<String> veg,
			@RequestParam(name = "nonveg", required = false) ArrayList<String> nonveg,
			@RequestParam(name = "bakery", required = false) ArrayList<String> bakery,
			@RequestParam(name = "juice", required = false) ArrayList<String> juice,
			@RequestParam(name = "italian", required = false) ArrayList<String> italian,
			@RequestParam(name = "continental", required = false) ArrayList<String> continental, Category catg,
			Model model, Ordertable ordertableOBJ, OlderOrderTable olderordert, FoodCounter foodcounter) {

		LocalDateTime expireTime = currentTime.plusHours(8);
		boolean statusflag = false;
		if (statusflag == false) {
			session.setAttribute("status", "Open");
			statusflag = true;
			model.addAttribute("status", session.getAttribute("status"));
		}
		ArrayList<String> list = new ArrayList<>(Arrays.asList(foodlist.split(",")));
		ordertableOBJ.setTotatprice(totalprice);
		ordertableOBJ.setUsername(username);
		ordertableOBJ.setDate(date);
		ordertableOBJ.setOrderList(list);
		ordertableOBJ.setExpiretime(expireTime);
		System.out.println(session.getAttribute("status"));
		ordertableOBJ.setStatus((String) session.getAttribute("status"));

		orderrepo.save(ordertableOBJ);

		catg.setBreakfast(breakfast);
		catg.setBakery(bakery);
		catg.setContinental(continental);
		catg.setItalian(italian);
		catg.setNonveg(nonveg);
		catg.setUser(username);
		catg.setVeg(veg);
		catg.setJuices(juice);
		catg.setOrderid(ordertableOBJ.getOrderid());
		catg.setDate(LocalDate.now());
		catrepo.save(catg);

		model.addAttribute("order", orderrepo.openconfirmStatus((String) session.getAttribute("user")));
		model.addAttribute("olderorder", olderorderrepo.getOrderDetails(username));

		flag = flag + 1;

		return "views/order";
	}

	@GetMapping("/order")
	public String loadOrder(Model model, ArrayList<Ordertable> order, ArrayList<OlderOrderTable> olderorder,
			HttpSession session) {

		model.addAttribute("order", orderrepo.openconfirmStatus((String) session.getAttribute("user")));
		model.addAttribute("olderorder", olderorderrepo.getOrderDetails((String) session.getAttribute("user")));

		List<Ordertable> orderExpiryList = orderrepo.getExpiryOrderDetail((String) session.getAttribute("user"));
		System.out.println(orderExpiryList);
		OlderOrderTable olderOrderTable = new OlderOrderTable();

		for (Ordertable obj : orderExpiryList) {

			if (currentTime.isAfter(obj.getExpiretime())) {
				int condition = orderrepo.deleteExpiryOrderDetail(obj.getExpiretime());
				System.out.println("bad output" + condition);
				if (condition == 1) {
					olderOrderTable.setDate(obj.getDate());
					olderOrderTable.setOrderid(obj.getOrderid());
					olderOrderTable.setOrderList(obj.getOrderList());
					olderOrderTable.setStatus("Order Expired");
					olderOrderTable.setTotatprice(obj.getTotatprice());
					olderOrderTable.setUsername(obj.getUsername());
					olderorderrepo.save(olderOrderTable);

				}
			}

		}
		return "views/order";
	}

	@GetMapping("/cancelOrder")
	public String cancleOrderByUSer(HttpSession session, @RequestParam("order") Integer orderid, Ordertable order,
			OlderOrderTable olderorder, Model model) {
		order = orderrepo.getById(orderid);
		olderorder.setDate(order.getDate());
		olderorder.setOrderid(order.getOrderid());
		olderorder.setOrderList(order.getOrderList());
		olderorder.setStatus("Cancel");
		olderorder.setTotatprice(order.getTotatprice());
		olderorder.setUsername(order.getUsername());
		olderorderrepo.save(olderorder);

		orderrepo.deleteById(orderid);
		model.addAttribute("order", orderrepo.openconfirmStatus((String) session.getAttribute("user")));
		model.addAttribute("olderorder", olderorderrepo.getOrderDetails((String) session.getAttribute("user")));
		return "views/Order";
	}

	@GetMapping("/done")
	public String fullfilledOrder(HttpSession session, @RequestParam("order") Integer orderid, Ordertable order,
			OlderOrderTable olderorder, Model model, Category cat, CategoryRepo categoryrepo) {
		order = orderrepo.getById(orderid);
		olderorder.setDate(order.getDate());
		olderorder.setOrderid(order.getOrderid());
		olderorder.setOrderList(order.getOrderList());
		olderorder.setStatus("Completed");
		olderorder.setTotatprice(order.getTotatprice());
		olderorder.setUsername(order.getUsername());

		for (String orderl : order.getOrderList()) {
			foodcntrepo.insertData(LocalDate.now(), orderl);
		}

		if (cat.getOrderid() == olderorder.getOrderid()) {
			olderorder.setCategory(cat);
			categoryrepo.save(cat);
		}
		olderorderrepo.save(olderorder);
		orderrepo.deleteById(orderid);
		model.addAttribute("order", orderrepo.openconfirmStatus((String) session.getAttribute("user")));
		model.addAttribute("olderorder", olderorderrepo.getOrderDetails((String) session.getAttribute("user")));

		return "views/feedback";
	}

	// ------------------------About-----------------------
	@GetMapping("/about")
	private String about() {
		return "views/about";
	}

	// --------------------------------------
	// Admin-----------------------------------

	@GetMapping("/adminlogin")
	public String adminLogin() {
		return "views/adminlogin";
	}

	@PostMapping(value = "/adminlogin")
	public String adminloginsuccess(HttpSession session, Login login) {

		if (login.getEmail().equals(repo.findById(login.getEmail()).get().getEmail())
				&& login.getPassword().equals(repo.findById(login.getEmail()).get().getPassword())) {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalTime localTime = LocalTime.now();
			session.setAttribute("admin", login.getEmail());
			session.setAttribute("logtime", dtf.format(localTime));
			System.out.println(login.getEmail());
			System.out.println(repo.findById(login.getEmail()).get().getEmail());
			System.out.println(login.getPassword());
			System.out.println(repo.findById(login.getEmail()).get().getPassword());
			return "views/admin";
		} else {

			return "error/404";
		}

	}

	@GetMapping("/adminlogout")
	public String logoutAdmin(HttpSession session) {
		session.removeAttribute("admin");

		return "views/adminlogin";
	}

	@GetMapping("/admin")
	public String AdminPanel(Model model) {
		if (flag > 0) {
			model.addAttribute("message", flag);
		}
		flag = 0;
		return "views/admin";
	}

	@GetMapping(value = "/Addfood")
	public String addProductPage() {
		return "views/Addfood";
	}

	@GetMapping(value = "/adminorder")
	public String adminordermethod(HttpSession session, Model model) {
		model.addAttribute("order", orderrepo.openStatusAdmin());
		model.addAttribute("recipe", reciperepo.findAll());
		return "views/adminorder";
	}

	@GetMapping("/declineOrder")
	public String cancleOrderByAdmin(HttpSession session, @RequestParam("order") Integer orderid, Ordertable order,
			OlderOrderTable olderorder, Model model) {
		order = orderrepo.getById(orderid);
		olderorder.setDate(order.getDate());
		olderorder.setOrderid(order.getOrderid());
		olderorder.setOrderList(order.getOrderList());
		olderorder.setStatus("Cancel By Restaurent");
		olderorder.setTotatprice(order.getTotatprice());
		olderorder.setUsername(order.getUsername());
		olderorderrepo.save(olderorder);
		orderrepo.deleteById(orderid);
		model.addAttribute("order", orderrepo.openStatusAdmin());

		return "views/adminorder";
	}

	@GetMapping("/acceptOrder")
	public String acceptOrderByAdmin(HttpSession session, @RequestParam("ordid") Integer orderid) {

		orderrepo.confirmOrderStatus(orderid);

		return "views/admin";
	}

	@Value("${uploadDir}")
	private String uploadFolder;

	@PostMapping("/savefoodDetails")
	public @ResponseBody ResponseEntity<?> createProduct(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("price") double price, @RequestParam("description") String categories, Model model,
			HttpServletRequest request, final @RequestParam("image") MultipartFile file) {
		try {

			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			log.info("uploadDirectory:: " + uploadDirectory);
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			log.info("FileName: " + file.getOriginalFilename());

			if (fileName == null || fileName.contains("..")) {
				model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
				return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName,
						HttpStatus.BAD_REQUEST);
			}

			String[] names = name.split(",");
			String[] categoriess = categories.split(",");
			Date createDate = new Date();
			log.info("Name: " + names[0] + " " + filePath);
			log.info("description: " + categoriess[0]);
			log.info("price: " + price);
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					log.info("Folder Created");
					dir.mkdirs();
				}
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();

			} catch (Exception e) {
				log.info("in catch");
				e.printStackTrace();
			}

			byte[] imageData = file.getBytes();
			Food food = new Food();
			food.setId(id);
			food.setFoodItem(names[0]);
			food.setPhoto(imageData);
			food.setPrice(price);
			food.setCategories(categoriess[0]);
			foodRepo.save(food);
			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Food Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	// ----------- ----------------------------------------------------

	@GetMapping("/reports")
	public String add(Model model) {
		model.addAttribute("ConfirmOrders", olderorderrepo.findAll());
		return "views/reports";
	}

	@PostMapping("/search")
	public String doSearchCustomerwise(@RequestParam("username") String username, Model model,
			ArrayList<OlderOrderTable> emp) {

		emp = olderorderrepo.getByUserName(username);
		System.out.println(emp);
		model.addAttribute("ConfirmOrders", emp);
		return "views/reports";
	}

	@GetMapping("/reportBydate")
	public String getTodayOrder(Model model) {
		System.out.println(olderorderrepo.findAll());
		model.addAttribute("OlderOrderTable", olderorderrepo.findAll());
		return "views/reportBydate";
	}

	@PostMapping(value = "/reportbyday")
	public String showTodayORder(@RequestParam("date") String date, Model model) {
		System.out.println(date);
		model.addAttribute("OlderOrderTable", olderorderrepo.getByUserDate(date));

		return "views/reportBydate";
	}

	@GetMapping(value = "/dailyCategorywiseReport")
	public String dailyCategoryWise(Model model) {

		model.addAttribute("ConfirmOrders", catrepo.getOrdersByCategory(LocalDate.now()));
		return "views/dailyCategorywiseReport";
	}

	@GetMapping("/topthree")
	public String topThreeFind(Model model) {
		model.addAttribute("ConfirmOrders", foodcntrepo.topThreeAllTime());
		return "views/topthree";
	}

	@PostMapping("/topthreeItems")
	public String topThreeBetweenDate(@RequestParam("date") String localdate, @RequestParam("date2") String localdate2,
			Model model, ArrayList<FoodCounter> emp) {
		emp = foodcntrepo.topThreeMovingItems(localdate, localdate2);
		System.out.println(emp);
		model.addAttribute("ConfirmOrders", emp);
		return "views/topthree";
	}

}
