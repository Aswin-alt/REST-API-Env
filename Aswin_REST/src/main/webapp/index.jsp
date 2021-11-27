<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
  Hello
  <form name="url" method="get" id="url" >
  
  		<div class="form-outline mb-4" style="text-align: left;">
			<label class="form-label text-left" for="name">Name</label> 
			<input type="text" id="name" class="form-control" size="50" name="name"/>
		</div>
  
  	<button type="submit" onclick="url1()">Submit</button>
  </form>
   		
  <script type=text/javascript>
  
 	function url1(){
		var name = document.getElementById("name").value;
	    var action = "people/"+name;
	    if(name != ""){
				  document.getElementById("url").action = action;
				  document.getElementById("url").submit();
			  }
		else{
				  alert("Enter name!");
			  }
	    
	}
  
</script>
  
</body>
</html>