//Login/Registration Block Hide / UnHide------------------------------------------------------
/* function displayConatiner(containername)
{
	if(document.body.contains(document.getElementById('sign-up-container'))){
		 document.getElementById("sign-up-container").style.display="none";
		 //document.getElementById("login_container").style.display="none";
		 let x = document.getElementById(containername);
		 
		  if (x.style.display === "none") {
	   		 x.style.display = "block";
	     	x.style.marginTop="200px";
	 
		  } else {
		    x.style.display = "none";
		  
		
		  }
	}
}
function displayConatiner1(containername)
{
	if(document.body.contains(document.getElementById('sign-up-container'))){
		 //document.getElementById("sign-up-container").style.display="none";
		 document.getElementById("login_container").style.display="none";
		 let x = document.getElementById(containername);
		 
		  if (x.style.display === "none") {
	   		 x.style.display = "block";
	     	x.style.marginTop="200px";
	 
		  } else {
		    x.style.display = "none";
		  
		
		  }
	}
}
*/



document.addEventListener("DOMContentLoaded", () => {
   displayConatiner();
  });


//Registration------------------------------------------------------






function registration()
{
	let fname=document.getElementById("fname").value;
	let lname=document.getElementById("lname").value;
	let email=document.getElementById("email").value;
	let phone=document.getElementById("phone").value;	
 	let pass1=document.getElementById("password1").value;
	let pass2=document.getElementById("password2").value;	
	
	if((mobileNumberValidator(phone)&&passwordMatcher(pass1, pass2))&&nameValidator(fname))
	{
		return true;
	}
	else
	{
		return false;
	}
	
	return false;


}

// kahi upyog nahi
function passwordMatcher(pass1, pass2)
{	

var passw=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/gm;
if(pass1.match(passw)&& pass2.match(passw) )
{
	if(pass1.match(pass2)){
		alert('Account Created SuccessFully')
	    return true;
	}
	else{
		/*const passfail= document.getElementById("passwordchecking");
		passfail.innerText="Password and Confirm Password dose not match";
		*/
		
		alert('Password and Confirm Password dose not match')
		return false;
	}	
}
else
{
	/* const passfail= document.getElementById("passwordchecking");
	passfail.innerText="7 to 16 characters which contain only characters, numeric digits, underscore and first character must be a letter]'";
	*/
	alert('Password Must -[7 to 16 characters which contain only characters, numeric digits, underscore and first character must be a letter]')	
	return false;
	
}		
}	


// kahi upyog nahi
function mobileNumberValidator(number)
{
	const regexExp = /^[6-9]\d{9}$/gi;
	if(regexExp.test(number)==false)
	{
		alert('Please Check Phone Number')
		return false;
	}
	return true;
}


// kahi upyog nahi
function nameValidator(fname)
{
	const regex = /^[a-zA-Z\-]+$/;
	if(regex.test(fname)==false)
	{
		alert('Please Check Name,Name Contains characters only')
		return false;
	}
	return true;
}
//-------------------------------------------------------------------------------
//Success html login

function login()
{
	sessionStorage.setItem("user", document.getElementById("email").value);
}


function sessionfun(){
if(sessionStorage.getItem("user")!=null)
{
	let aItem= document.createElement("a");
	aItem.setAttribute('class','manu-item');
	aItem.setAttribute('id','sessionA');
	aItem.setAttribute('onclick','logout()');
	document.getElementById("sessionLI").appendChild(aItem);
	document.getElementById("sessionA").innerText=sessionStorage.getItem("user");
	
	
}
if(sessionStorage.getItem("user")==null)
{var aItem= document.createElement("a");
aItem.setAttribute('class','manu-item');
aItem.setAttribute('href','account');
aItem.setAttribute('id','sessionA');
document.getElementById("sessionLI").appendChild(aItem);
document.getElementById("sessionA").innerText="Log-In/Sign-Up";
	
	}
}

function logout()
{
		
	
	
	let nestedList= document.createElement("ul");
	nestedList.setAttribute('id','logoutUL');
	let nestedListItem= document.createElement("li");
	let aItem2= document.createElement("a");
	aItem2.setAttribute('id','logout');
	aItem2.setAttribute('onclick','logoutFunction()');
	nestedListItem.appendChild(aItem2);
	nestedList.appendChild(nestedListItem);
	document.getElementById("sessionLI").appendChild(nestedList);
	document.getElementById("logout").innerText="Log-out";
	
	
	 

}

function logoutFunction()
{
	sessionStorage.removeItem("user");
	window.alert("Log-Out SucccessFull");
	location.href="logout";
}

