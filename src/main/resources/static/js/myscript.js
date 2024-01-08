



//-------------------------------------------------------------------------------
//Success html login



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
document.getElementById("sessionA").innerText="Log-In";
	
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
	location.href="index";
	//document.location.reload(true);
	
}


        var total = 0;
        // Index
        var i = 1;

     
        var itemCost = [];
	
		var foodCart={};
		
        // Add to cart
        function add(n){

		showcartdiv();
	
             brand = "food" + n;
            priceId = "price" + n;
            quantityId = "quantity" + n;
            
            name = document.getElementById(brand).innerHTML;
            // price
            price = document.getElementById(priceId).innerHTML;
            // quantity
            quantity = document.getElementById(quantityId).value;
            // Creating a li element to add it to ul 
            var node = document.createElement("LI");
            // id of li element
            item = "item"+i;
            node.setAttribute("id", item)
            node.setAttribute("class", "foodItem")
            // cost of the selected shirt
            itemCost[i-1] = Number(price) * Number(quantity);
            // Updating the index i 
            i += 1;
            // text of the li element
       		let nodea=document.createElement("a");
       		nodea.setAttribute("class","fooditemname");
       		let nodee=document.createElement("a");
       		let nodeclass=document.createElement("a");
       		nodeclass.setAttribute("class","foodcat")
       		nodee.setAttribute("class","fooditemprice");
            var textnode = document.createTextNode(" "+name);
            var textnoda = document.createTextNode(" "+quantity+" x "+price+"  ");
           
			
         	 let textnodeclass=document.createTextNode(document.getElementById(name).parentElement.className);
       		 let lst="fooditemname "+document.getElementById(name).parentElement.className;
       		 nodea.setAttribute("class",lst);
       		nodeclass.appendChild(textnodeclass);
           	nodea.appendChild(textnode);
            nodee.append(textnoda);
            // add the text to li element
            //node.appendChild(textnode);
      		 node.append(nodeclass,nodea,nodee);
      	
            // add li element to ul list
            document.getElementById("items").appendChild(node);

            total += Number(price) * Number(quantity);
            // update the total
            document.getElementById("total").innerHTML = "Total: " + total.toFixed(2) + " Rs";
            
            // Add a remove button 
            document.getElementById(item).innerHTML += '<button class="remove" onclick="deleItem('+"'"+item+"'"+')">Remove</button>';
     
            
        }

         // delete message when the select element is clicked
         function deleteE(eId) {
   
            document.getElementById(eId).innerHTML = ' ';
        }

        // Remove a product from the cart
        function deleItem(eId){
			
            document.getElementById(eId).remove();
            
            n = Number(eId.slice(-1)) - 1;
            // remove the cost of the product deleted from the cart
            total -= itemCost[n];
            // Updating the cost of products in the cart
            document.getElementById("total").innerHTML = "Total: " + total.toFixed(2) + " Rs"; 
        
        
    }
       
       var foodcartlist=[]; 
      function foodorder()
      {
		if(sessionStorage.getItem("user")!=null)
		{
			for(let z=0;z<document.getElementsByClassName("fooditemname").length;z++)
			{
				foodcartlist.push(document.getElementsByClassName("fooditemname")[z].firstChild.data);
			}
			
			foodCart.total=total;
			foodCart.foodNames=foodcartlist
			foodCart.userName=sessionStorage.getItem("user");
			console.log(foodCart);
         let breakfast=[];
			
			for(let i=5;document.getElementsByClassName('breakfast').length>i;i++)
			{
				breakfast.push(document.getElementsByClassName('breakfast')[i].innerText);
				 
			}
	     let veg=[];
			
			for(let i=5;document.getElementsByClassName('veg').length>i;i++)
			{
				veg.push(document.getElementsByClassName('veg')[i].innerText);
				 
			}
			
			let nonveg=[];
			
			for(let i=5;document.getElementsByClassName('nonveg').length>i;i++)
			{
				nonveg.push(document.getElementsByClassName('nonveg')[i].innerText);
				 
			}
			
				let bakery=[];
			
			for(let i=5;document.getElementsByClassName('bakery').length>i;i++)
			{
				bakery.push(document.getElementsByClassName('bakery')[i].innerText);
				 
			}
			
				let juice=[];
			
			for(let i=5;document.getElementsByClassName('juices').length>i;i++)
			{
				juice.push(document.getElementsByClassName('juices')[i].innerText);
				 
			}
			
					let italian=[];
			
			for(let i=5;document.getElementsByClassName('italian').length>i;i++)
			{
				italian.push(document.getElementsByClassName('italian')[i].innerText);
				 
			}

		let continental=[];
			
			
			for(let i=5;document.getElementsByClassName('continental').length>i;i++)
			{
				continental.push(document.getElementsByClassName('continental')[i].innerText);
				 
			}
			if(total>0)
			{
				
				location.href="saveorder?"+"fooditems="+foodCart.foodNames+"&"+"total="+foodCart.total+"&"+"user="+foodCart.userName+"&"+"breakfast="+breakfast+"&"+"veg="+veg+"&"+"nonveg="+nonveg+"&"+"bakery="+bakery+"&"+"juice="+juice+"&"+"italian="+italian+"&"+"continental="+continental;
			}
			else
			{
				alert("Add Some Thing In to the Cart");
			}		
		
		
		}
		else
		{
			alert("Please Log In  OR Create Account");
			document.location.href="account";
			
		}
			

}

// food cart div hide------------------------------------------------------------------------




//-------------------------------------food manu table------------------------------------------------------------------









//-------------------------------------order -----------------------------------------------

function orderTable()
{
	
	if(sessionStorage.getItem("user")==null)
	{
		document.querySelector(".orderTable").style.display="none";
		alert("Please Login OR Create Account");
		location.href="account";
	} 

}
function buttonHide()
{
		for(let i=0;document.getElementsByClassName("statusth").length>i;i++)
		{
			if(document.getElementsByClassName('statusth')[i].innerText.match('Confirm'))
			{
				document.getElementsByClassName("cancelorder")[i].style.display="none";
			}
			if(document.getElementsByClassName('statusth')[i].innerText.match('Open'))
			{
				document.getElementsByClassName("doneorder")[i].style.display="none";
				
			}		
		}
}
function todayHide()
{
	for(let i=0;document.getElementsByTagName('td').length >i;i++)
  {
   if(document.getElementsByTagName('td')[i].innerText=="[]")
     {
       document.getElementsByTagName('td')[i].innerText=null
       
     }
    
   
  }}