
 $(document).ready(function() {
 $("#submit").on("click", function() {
	
	$("#submit").prop("disabled", true);
	var id = $("#id").val();
	var name = $("#name").val();
	var file = $("#image").val(); 
	  var price = $("#price").val();
	  var category = $("#description").val();
	var form = $("#form").serialize();
	var data = new FormData($("#form")[0]);
	data.append('id', id);
	data.append('name', name);
	data.append('price', price);
	data.append('category', category); 
	 if (id===""||name === "" || file === "" || price === ""|| category === "") {
		$("#id").css("border-color", "red");
		 $("#name").css("border-color", "red");
		 $("#image").css("border-color", "red");
		 $("#price").css("border-color", "red");
		 $("#description").css("border-color", "red");
		}
		
		else{
			$("#id").css("border-color", "");
			$("#name").css("border-color", "");
            $("#image").css("border-color", "");
            $("#price").css("border-color", "");
            $("#description").css("border-color", "");
            
             $.ajax({
			
			 	type: 'POST',
				enctype: 'multipart/form-data',
				data: data,
				 url: "savefoodDetails", 
				processData: false,
                   contentType: false,
                    cache: false,
			success: function(data, statusText, xhr)
			{
				console.log(xhr.status);
				if(xhr.status == "200") {
					alert("food Add Successfully");
					
					}
			},
			error:function(e)
			{
				alert("Some Thing WRONG");
				 location.reload();
			}
			
			
			
						});
            
		}
	
	});
	});
	const btn = document.querySelector(".submit-rating");
const thanksmsg = document.querySelector(".thanks-msg");
const starRating = document.querySelector(".star-input");
// Success msg show/hide
btn.onclick = () => {
    starRating.style.display = "none";
    thanksmsg.style.display = "table";
    return false;
};