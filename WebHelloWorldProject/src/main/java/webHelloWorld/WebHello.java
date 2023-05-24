package webHelloWorld;

import java.io.IOException;
import java.io.PrintStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebHello
 */
@WebServlet("/WebHello")
public class WebHello extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WebHello() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintStream out = new PrintStream(response.getOutputStream());
		out.println("Hello World, so cool to develope Web Services.");
		
		out.println("<h1>Vanierr College</h1>");

		double prd_Price = 5.99;
		int prd_Qty = 6;
		double tot_Billing;
		
		tot_Billing  = prd_Price * prd_Qty;
		//Display it  as table
		out.println("<table border = \"1 \" style=\"text-align: center;\"><tr>");
		out.println("<th style=\"padding: 10px;\"> prd price</th>"
				+ "<th style=\"padding: 10px;\">prd Qty</th>"
				+ "<th style=\"padding: 10px;\">tot Billing</th></tr>");
		out.println("<tr><td style=\"padding: 10px;\">" +prd_Price+ "</td>"
				+ "<td style=\"padding: 10px;\">" +prd_Qty+"</td>"
				+ "<td style=\"padding: 10px;\">" +tot_Billing+"</td></tr></table>");
		
		University myUniversity = new University("Montreal University" , 2023 , 3);
		out.println("</br>"+myUniversity.getName() +  "</br>");
		out.println(myUniversity.getYearOfEstablishment()+  "</br>");
		out.println(myUniversity.getNumOfPrograms());
		
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
