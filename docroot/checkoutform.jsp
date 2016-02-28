<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><meta name="keywords" content="" /><meta name="description" content="" /><link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<title>Insert title here</title>

<script type="text/javascript">

</script>
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
  <li><a href="HotelHandler?choice=viewall" accesskey="5" title="">View Rooms</a></li> 
  <li class="first"><a href="HotelHandler?choice=checkout" accesskey="6" title="">Check out</a></li> 
    <li><a href="logout.jsp" accesskey="7" title="">Logout</a></li>
 </ul> 
               
</div><hr />
<%ArrayList customers=new ArrayList(); %>
<% customers=(ArrayList)request.getAttribute("occupied"); %>
<form name="form5" action="HotelHandler" >
<table align="center">
<tr>
<td>
<h3>Select room and customer to checkout</h3>
</td>
</tr>

<tr>
<td>
<select name="check" >
<% for(int i=0;i<customers.size();i++){%>

<option value=<%=((Customer)customers.get(i)).getRoom().getRoomNo()%>><%=((Customer)customers.get(i)).getName()%>--<%=((Customer)customers.get(i)).getRoom().getRoomNo() %>   
 </option>


<%} %>

</select>
</td>
</tr>
<input type="hidden" name="choice" value="checkout1"/>

<tr><td><input type="submit"  value="Checkout"/></td></tr>

</table>
</form>

</div>
</body>
</html>