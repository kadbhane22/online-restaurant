function foodhidetable()
{
	document.getElementsByClassName('container')[0].style.display='none';
	document.getElementsByClassName('menu-title')[0].style.display='none';

}


foodhidetable();
function foodshowtable()
{
	document.getElementById('foodshowtable').style.display="none";
	document.getElementsByClassName('container')[0].style.display='block';
	document.getElementsByClassName('menu-title')[0].style.display='block';


}

function showcartdiv()
{
	
document.getElementsByClassName('cart')[0].style.display='block';
document.getElementsByClassName('footer-conatiner')[0].style.display='block';


}
//hide cart
function hidecartdiv()
{
	if(total==0)
	{
document.getElementsByClassName('cart')[0].style.display='none';
document.getElementsByClassName('footer-conatiner')[0].style.display='none';
}

}
hidecartdiv();

//----------------------------------------------------------- Hide Show Table Catogeries--------------------------------
let breakfast = document.querySelector(".breakfast");
let veg= document.querySelector(".veg");
let nonveg= document.querySelector(".nonveg");
let juice= document.querySelector(".juice");
let Bakery= document.querySelector(".Bakery");
let It= document.querySelector(".Italian");
let Continental= document.querySelector(".Continental");



var list=[breakfast,veg,nonveg,juice,Bakery,It,Continental];

function showMenu(nameofdiv)
{
	for(let i=0;i<list.length;i++)
	{
		if(list[i]===nameofdiv)
		{
			var spliced =list.splice(i,1);
		}
	}
	
	for(let i = 0; i < list.length; i++) {
  
   for(let j = 0; j < list[i].length; j++) {
     
      console.log(list[i][j]);
   }
}
	
}

////////////////////////////////////////////////////////////////////////
/*
function manuhide()
{
	if(document.body.contains(document.getElementById('tablebreakfast')))
	{
		document.getElementById('tablebreakfast').style.display="none";
		document.getElementById('tableVeg').style.display="none";
			let g=document.getElementsByClassName("veg");
		for(var i = 0; i < g.length; i++){
    g[i].style.display="none";   // Change the content
    }
    
    	let k=document.getElementsByClassName("breakfast");
		for(var i = 0; i < k.length; i++){
    k[i].style.display="none";   // Change the content
    }
    
	}
	
}
manuhide();
function showBreakfast()
{
	document.getElementById('tablebreakfast').style.display="block";
	document.getElementById('tableVeg').style.display="none";
	let k=document.getElementsByClassName("breakfast");
		for(var i = 0; i < k.length; i++){
    k[i].style.display="block";   // Change the content
    }
    
    let g=document.getElementsByClassName("veg");
		for(var i = 0; i < g.length; i++){
    g[i].style.display="none";   // Change the content
    }
}
function showVeg()
{
		let k=document.getElementsByClassName("breakfast");
		for(var i = 0; i < k.length; i++){
    k[i].style.display="none";   // Change the content
    }
			let g=document.getElementsByClassName("veg");
		for(var i = 0; i < g.length; i++){
    g[i].style.display="block";   // Change the content
    }


}
*/

	





