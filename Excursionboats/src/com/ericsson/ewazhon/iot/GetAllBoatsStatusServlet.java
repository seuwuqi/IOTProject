package com.ericsson.ewazhon.iot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ericsson.ewazhon.middle.ReadAllBoatsStatus;
import com.ericsson.ewazhon.model.LatestStatus;

import net.sf.json.*;

/**
 * Servlet implementation class ReadStatusServlet
 */
@WebServlet("/ReadStatusServlet")
public class GetAllBoatsStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllBoatsStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Vector<LatestStatus> allBoatsStatus;
		ReadAllBoatsStatus bs = new ReadAllBoatsStatus();
		
		try {
			allBoatsStatus = bs.selectLatestStatusRequst();
			
			String jasonStr = JSONArray.fromObject(allBoatsStatus).toString();
			System.out.println("############################  jason string is  ############################");
			System.out.println(jasonStr);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(jasonStr);
			out.flush();
			
		} catch (Exception ext) {

			System.out.println("Exception ");
			getServletContext().log(ext.getMessage());

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String strResponse = "<html><body><h1>Error happened </h1> "
					+ ext.getMessage() + "</body></html>";
			out.println(strResponse);
			System.out.println(strResponse);
			out.flush();
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
