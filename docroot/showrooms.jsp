<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*,model.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><meta name="keywords" content="" /><meta name="description" content="" /><link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<title>Insert title here</title>

<script type="text/javascript">
function validate()
{


if(document.availablerooms.name.value=="")
{
alert("Please enter customer name to book");
return false;
}


var name=document.availablerooms.name.value;

spl="0123456789 ";
for(i=0;i<name.length;i++)
 {
	if(spl.indexOf(name.charAt(i))!=-1)
	{
		alert("Please enter only alphabets");
		document.availablerooms.name.focus();
		document.availablerooms.name.value="";
		return false;
	}
 }



if(document.availablerooms.address.value=="")
{
alert("Please enter address");
return false;
}

flag=false;
for(i=0;i<document.availablerooms.roomlist.length;i++)
 {
  if(document.availablerooms.roomlist[i].checked)
  {
  flag=true;
  }
  
  if(document.availablerooms.roomlist[document.availablerooms.roomlist.length-1].checked)
  {
  flag=false;
  alert("please select a room");
  return false;
  }
  
 }

if(!flag)
{
alert("Please select a room");
return flag;
}

return true;

}

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
  <li class="first"><a href="checkavailability.html" accesskey="3" title="">Check Availability and Book</a></li> 
  <li><a href="HotelHandler?choice=viewOccupied" accesskey="4" title="">View Ocuupied rooms</a></li> 
  <li><a href="HotelHandler?choice=viewall" accesskey="5" title="">View Rooms</a></li> 
  <li><a href="HotelHandler?choice=checkout" accesskey="6" title="">Check out</a></li> 
    <li><a href="logout.jsp" accesskey="7" title="">Logout</a></li>
 </ul> 
               
</div><hr />
<form name="availablerooms" action="HotelHandler" onsubmit="return validate();" >
<% ArrayList roomList=(ArrayList)request.getAttribute("rooms");%>

<table align="center">
<tr>

<td><h3>List of available rooms </h3></td>
<% for(int i=0;i<roomList.size();i++){%>
<td>
<h3><input type="radio" name="roomlist" value=<%=((Room)roomList.get(i)).getRoomNo()%> /><%=((Room)roomList.get(i)).getRoomNo()%></h3>
</td>
<%}%>
<td><h3><input type="radio" name="roomlist"/>none</h3></td>

</tr>
</table>



<table align="center">
 <tr>
   <td> Customer Name: </td> 
   <td>   <input type="text" name="name"/> </td>
 </tr>
  <tr>
   <td>Customer Address: </td>
   <td> <textarea  rows="5" columns="20" name="address" ></textarea></td>
  </tr>
  <input type="hidden" name="choice" value="book"/>
  <tr>
   <td> <a href="adminhome.html" >Admin home</a></td>
   <td> <input type="submit" value="book"/> </td>
  
   
  </tr>
  </table>
  
</form>
</div>
</body>
</html>