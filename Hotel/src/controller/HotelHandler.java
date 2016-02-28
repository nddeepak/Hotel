package controller;

import javax.servlet.http.*;
import model.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;


/**
 * Servlet Class
 *
 * @web.servlet              name="HotelHandler"
 *                           display-name="Name for HotelHandler"
 *                           description="Description for HotelHandler"
 * @web.servlet-mapping      url-pattern="/HotelHandler"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class HotelHandler extends HttpServlet {

	public HotelHandler() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException,
		IOException {
		
		String choice=req.getParameter("choice");
		HttpSession hs =req.getSession(false);
		if(hs!=null)
		{
		
		if(choice.equals("checkavailability"))
		{
		String type=req.getParameter("type");
		
		int noOfBeds=Integer.parseInt(req.getParameter("room"));
		Room room=new Room(type,noOfBeds);
		Hotel h=new Hotel();
		ArrayList<Room> rooms=h.checkAvailability(room);
		if(rooms.size()==0)
		{
			resp.sendRedirect("roomnotavailable.html");
		}
		else
		{
			req.setAttribute("rooms",rooms);
			RequestDispatcher rs=req.getRequestDispatcher("showrooms.jsp");
			rs.forward(req, resp);
		}
		}
/*		if(choice.equalsIgnoreCase("addroomcustomer"))
		{
			
			HttpSession hs=req.getSession(false);
			Room room=(Room)hs.getAttribute("room");
			
			
			Hotel h=new Hotel();
			
		}*/
		
		if(choice.equalsIgnoreCase("viewall"))
		{
			Hotel h=new Hotel();
			ArrayList<Room> rooms=h.viewAllRooms();
			req.setAttribute("roomList",rooms);
			
			req.getRequestDispatcher("displayall.jsp").forward(req,resp);
			
		}
		
				
		if(choice.equals("book"))
		{
			int roomNo=Integer.parseInt(req.getParameter("roomlist"));
			Hotel h=new Hotel();
			Room room=new Room();
			room.setRoomNo(roomNo);
			String name=req.getParameter("name");
			String address=req.getParameter("address");
			Customer customer=new Customer(name,address,room);
			int custstatus=h.addCustomer(customer);
			int roomstatus=h.changeStatus(room);
			if(custstatus==0 || roomstatus==0)
			{
				resp.sendRedirect("bookingfailure.html");
			}
			else
				resp.sendRedirect("bookingsuccess.html");
		}
		if(choice.equals("checkout1"))
		{
			
			int roomNo=Integer.parseInt(req.getParameter("check"));
			
			Room room=new Room();
			room.setRoomNo(roomNo);
			Hotel h=new Hotel();
			int checkOutStatus=h.checkOutRoom(room);
			
			if(checkOutStatus!=0)
			{
				resp.sendRedirect("checkoutsuccess.html");
				
			}
			else
				resp.sendRedirect("checkoutfailure.html");
			
		}
		
		if(choice.equals("checkout"))
		 {
		  Hotel h=new Hotel();
		  ArrayList<Customer> cust=h.getOccupancyDetails();
		  if(cust.size()==0)
			{
			resp.sendRedirect("noOccupancy.html");
			}
		  else
			{
			  req.setAttribute("occupied",cust);
			  RequestDispatcher rs=req.getRequestDispatcher("checkoutform.jsp");
			  rs.forward(req, resp);

			}

        }
		
		if(choice.equals("viewOccupied"))
				 {
				  Hotel h=new Hotel();
				  ArrayList<Customer> cust=h.getOccupancyDetails();
				  if(cust.size()==0)
					{
					resp.sendRedirect("noOccupancyView.html");
					}
				  else
					{
					  req.setAttribute("occupied",cust);
					  RequestDispatcher rs=req.getRequestDispatcher("showOccupancy.jsp");
					  rs.forward(req, resp);

					}

		         }
		
		if(choice.equals("addrooms"))
		{
			
			
			Hotel h=new Hotel();
			String status=req.getParameter("status");
			int roomNo=Integer.parseInt(req.getParameter("roomno"));
			String roomType=req.getParameter("type");
			int noOfBeds=Integer.parseInt(req.getParameter("room"));
			Room room=new Room(roomNo,roomType,noOfBeds);
			
			if(status.equals("occupied"))
			{
				
				String name=req.getParameter("name");
				String address=req.getParameter("address");
				Customer cust=new Customer(name,address,room);
				room.setAvailabilityStatus(false);
				int row=h.addRoom(room);
				if(row>0)
				{
					int ret=h.addCustomer(cust);
					if(ret>0)
					{
						resp.sendRedirect("roomadded.html");
					}
					else
					{
						resp.sendRedirect("notadded.html");
						
					}
				}
				else
				{
					resp.sendRedirect("notadded.html");
				}
				
			}
			else
			{
				room.setAvailabilityStatus(true);
				
				int row=h.addRoom(room);
				if(row==0)
				{
					resp.sendRedirect("notadded.html");
				}
				else
				{
					resp.sendRedirect("roomadded.html");
				}
				
				
			}
		}
		}
		else
			resp.sendRedirect("sessionerror.jsp");
	}

}
