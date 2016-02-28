package controller;

import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.*;
import model.*;

/**
 * Servlet Class
 *
 * @web.servlet              name="loginHandler"
 *                           display-name="Name for loginHandler"
 *                           description="Description for loginHandler"
 * @web.servlet-mapping      url-pattern="/loginHandler"
 * @web.servlet-init-param   name="A parameter"
 *                           value="A value"
 */
public class loginHandler extends HttpServlet {

	public loginHandler() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException,
		IOException {
		
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		Manager l=new Manager(name,pass);
		boolean flag=l.validate();
		if(flag)
		{
			HttpSession hs=req.getSession(true);
			hs.setAttribute("name",name);
			hs.setAttribute("pass",pass);
		 resp.sendRedirect("adminhome.html");
		}
		else
		{
		 resp.sendRedirect("loginerror.jsp");
		}
	}

}
