<%@page import="com.studentmvc.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
    if(request.getAttribute("myobj")!=null){
	 	Student st = (Student) request.getAttribute("myobj");
	 	int id = st.getId();
	 	String name = st.getName();
	 	String phone = st.getPhone();
	 	String city = st.getCity();
	 	String gender = st.getGender();
	 	int marks = st.getMarks();
	 	System.out.println(gender);
	 	%>
	 	
	 	<form  action="UpdateStudentController" method="post">
    		
    			<div class="row">
    			
    				<div  class="col-lg-4">
    				
    						<div class="mb-3">
    							 <label for="id" class="form-label">Id</label>
   								 <input readonly="readonly" type="text" value=<%=id %> class="form-control" id="id" name="id">
  							</div>
    				
    				</div>
    				
    				
    				<div  class="col-lg-4">
    				
    						<div class="mb-3">
    							 <label for="name" class="form-label">Name</label>
   								 <input type="text" value=<%=name %> class="form-control" id="name" name="name">
  							</div>
    				
    				</div>
    			
    			</div>
    			
    			
    			<div class="row">
    			
    				<div  class="col-lg-4">
    				
    						<div class="mb-3">
    							 <label for="marks" class="form-label">Marks</label>
   								 <input type="text" value=<%=marks %> class="form-control" id="marks" name="marks">
  							</div>
    				
    				</div>
    				
    				
    				<div  class="col-lg-4">
    				
    						<div class="mb-3">
    							 <label for="phone" class="form-label">Phone</label>
   								 <input type="text" value=<%=phone %> class="form-control" id="phone" name="phone">
  							</div>
    				
    				</div>
    			
    			</div>
    			
    			
    			
    			
    			<div class="row">
    			
    				<div  class="col-lg-4">
    				
    				
    						<div class="form-check">
    						
  						
 							    <%
 							    	if(gender.equals("Male")){
 							    		%>
 							    		    
 							    			<input class="form-check-input" checked type="radio" value="male" id="gender-m" name="gender">
 							    		<% 
 							    	}else{
 							    		%>
							    		    
							    			<input class="form-check-input"  type="radio" value="male" id="gender-m" name="gender">
							    		<% 
 							    	}
 							    %>
 							  
               						<label class="form-check-label" for="gender-m">Male</label>
							</div>
							
							<div class="form-check">
							
							   <%
 							    	if(gender.equals("Female")){
 							    		%>
 							    		    
 					<input class="form-check-input" checked type="radio" value="female" id="gender-f" name="gender">
 							    		<% 
 							    	}else{
 							    		%>
							    		    
						<input class="form-check-input" type="radio" value="female" id="gender-f" name="gender">	    			
							    		<% 
 							    	}
 							    %>
 							  
							
						
  								
 							    <label class="form-check-label" for="gender-f">Female
               					</label>
							</div>
    				
    				</div>
    				
    				
    				<div  class="col-lg-4">
    				
    						<select class="form-select" aria-label="Default select example" name="city">
  								 <option selected>select city</option>
 								 <option >Pune</option>
 								 <option >Mumbai</option>
  								 <option >Buldana</option>
							</select>
    				
    				</div>
    			
    			</div>
    			
    			
    			<div class="row">
    			
    				<div  class="col-lg-4">
    				
    				<input type="submit" class="btn btn-success" value ="Register" >
    				
    				</div>
    			
    			
    			
    			
    		</form>
	 	
	 	
	 		
	 	<%
    }

 		 
 %>
 
</body>
</html>