package com.reva.water.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reva.water.util.InvalidInputException;

import com.reva.water.bean.WaterBillBean;
import com.reva.water.service.Administrator;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		String op = request.getParameter("operation");
		
		if("generate".equals(op)) 
		{
			String msg=null;
			try {
				msg = generateWaterBill(request);
				System.out.println(msg);
			} catch (SQLException | InvalidInputException e) {
				response.sendRedirect("error.html");				
			}

			finally {
				if("Fail".equals(msg) || "Already exists".equals(msg))
				{
					response.sendRedirect("error.html");				
				}
				else if("Success".equals(msg))
				{
					response.sendRedirect("success.html");					
				}
			}
			
		}
				

		else if("view".equals(op)) {
			WaterBillBean bean  = viewWaterBill(request);
			if(bean == null) {
                request.setAttribute("notFound", "true");
				request.getRequestDispatcher("displayBill.jsp").forward(request, response);;
			}
			else {
				request.setAttribute("beanObject",bean);
				request.getRequestDispatcher("displayBill.jsp").forward(request, response);;
			}
		}
	}
	
	
	public String generateWaterBill(HttpServletRequest request) throws InvalidInputException, SQLException
	{
		WaterBillBean bean = new WaterBillBean();
		Administrator admin = new Administrator();
		
		bean.setConsumerNumber(Integer.parseInt(request.getParameter("consumerNum")));
		bean.setBillMonth(request.getParameter("billMonth"));
		bean.setYear(request.getParameter("billYear"));
		bean.setStartReading(Integer.parseInt(request.getParameter("startReading")));
		bean.setCurrentReading(Integer.parseInt(request.getParameter("currentReading")));
		bean.setConnectionType(request.getParameter("connType"));
		return admin.addWaterBill(bean);		
	}
	
	public WaterBillBean viewWaterBill(HttpServletRequest request)
	{
		try {			
			Administrator admin = new Administrator();
			String billMonth = request.getParameter("billMonth");
			int consumerNum = Integer.parseInt(request.getParameter("consumerNum"));
			String billYear = request.getParameter("billYear");
			return admin.viewWaterBill(consumerNum, billMonth, billYear);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
