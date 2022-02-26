<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Add Employee</h4>
	<form action="/addEmployee">
	    <table>
	    <tr>
	    	<th>ID    :</th>
	    	<th><input type="text" name="id"/></th>
	    </tr>
	    <tr>
	    	<th>Name  :</th>
	    	<th><input type="text" name="name"/></th>
	    </tr>
	    <tr>
	    	<th>Salary:</th>
	    	<th><input type="text" name="salary"/></th>
	    </tr>
	    <tr>
	    	<th colspan=2><input type="submit" /></th>
	    </tr>
	     
	    </table>
			 
	</form>
	<hr/>
	<h4>Show Employee</h4>
	<form action="/showEmployee">
		 <table>
		   <tr>
				<th>ID    :</th>
		    	<th><input type="number" name="id"/></th>
		    	<th colspan=2><input type="submit" title="show Employee" /></th>
		    </tr>
	    </table>
	</form>    
</body>
</html>