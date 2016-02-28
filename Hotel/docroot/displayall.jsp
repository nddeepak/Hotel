<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*,model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><meta name="keywords" content="" /><meta name="description" content="" /><link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<title>Insert title here</title>


</head>
<body>
<div id="header"> 
<div id="logo"> 
 <h1>ABC Hotel</h1> 
 <h2>Comfort Zone</h2> 
</div> 
<div id="menu"> 
 <ul> 
  <li><a href="adminhome.html" accesskey="1" title="">Home</a></li>
  <li><a href="addroom.html" accesskey="2" title="">Add Room</a></li>   
  <li><a href="checkavailability.html" accesskey="3" title="">Check Availability and Book</a></li> 
  <li><a href="HotelHandler?choice=viewOccupied" accesskey="4" title="">View Ocuupied rooms</a></li> 
  <li class="first"><a href="HotelHandler?choice=viewall" accesskey="5" title="">View Rooms</a></li> 
  <li><a href="HotelHandler?choice=checkout" accesskey="6" title="">Check out</a></li> 
    <li><a href="logout.jsp" accesskey="7" title="">Logout</a></li>
 </ul> 
               
</div><hr />
<table align="center" border="2" bgcolor=#406800>

<% ArrayList it=(ArrayList)request.getAttribute("roomList");%>
<tr>
<td>
Room No
</td>

<td>
Vacant
</td>

<td>
Room Type
</td>

<td>
Bedroom Type
</td>
</tr>
<%for(int i=0;i<it.size();i++){%>
	<% Room r=(Room)(it.get(i));%>
	<% String status; %>
	<%if(r.getAvailabilityStatus()) { status="yes";%>
	
	<tr><td><%out.println(r.getRoomNo());%></td> <td><%out.println(status);%></td> <td><%out.println(r.getRoomType());%></td> <td><%out.println(r.getNoOfBeds());%></td> </tr><%} else{status="no";%>
	
<tr bgcolor="blue"><td><%out.println(r.getRoomNo());%></td> <td><%out.println(status);%></td> <td><%out.println(r.getRoomType());%></td> <td><%out.println(r.getNoOfBeds());}}%></td> </tr>
</table>
</div>
</body>
</html>
