package webBillingServlet;

import java.io.IOException;
import java.io.PrintStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class WebBillingServlet
 */
@WebServlet("/WebBillingServlet")
public class WebBillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WebBillingServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintStream out = new PrintStream(response.getOutputStream());
		
		Billing [] BillingRecords= new Billing[3];
        
		BillingRecords[0] = createBillingRecord( "Johnston", "Jane" , "Chair", 99.99 , 2 );
		BillingRecords[1] = createBillingRecord( "Fikhali", "Samuel" , "Table", 139.99 , 1 );
		BillingRecords[2] = createBillingRecord( "Samson", "Amina" , "KeyUSB", 14.99 , 2 );
        

		double TotalBilling = 0.00;
		out.println("<table border = 1 style=\"text-align: center; margin-top: 40px; margin-left: 35%;\"><tr>");
		out.println("<th style=\"padding: 10px;\"> Client_LName </th>"
				+ "<th style=\"padding: 10px;\">Client_FName</th>"
				+ "<th style=\"padding: 10px;\">Product_Name</th>"
				+ "<th style=\"padding: 10px;\">Prd_Price</th>"
				+ "<th style=\"padding: 10px;\">Prd_Qty</th>"
				+ "<th style=\"padding: 10px;\">Total Billing</th></tr>");
		for(Billing BillingRecord : BillingRecords) 
		{
			out.println("<tr><td style=\"padding: 10px;\">" +BillingRecord.getClient_LName()+ "</td>"
				+ "<td style=\"padding: 10px;\">" +BillingRecord.getClient_FName()+"</td>"
				+ "<td style=\"padding: 10px;\">" +BillingRecord.getProduct_Name()+"</td>"
				+ "<td style=\"padding: 10px;\">" +BillingRecord.getPrd_Price()+"</td>"
				+ "<td style=\"padding: 10px;\">" +BillingRecord.getPrd_Qty()+"</td>"
				+ "<td style=\"padding: 10px;\">" +BillingRecord.CalculateBilling()+"</td></tr>");
			
			TotalBilling += BillingRecord.CalculateBilling();

		};
		out.println("</table>");
		out.println("<h2 style=\"text-align: center; margin-top: 40px; \">The Total of Course Fee is: "+TotalBilling+" $</h2>");

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
    private Billing createBillingRecord(String client_LName, String client_FName, String product_Name, double prd_price, int prd_Qty) {
        Billing billing = new Billing();
        billing.setClient_LName(client_LName);
        billing.setClient_FName(client_FName);
        billing.setProduct_Name(product_Name);
        billing.setPrd_Price(prd_price);
        billing.setPrd_Qty(prd_Qty);
        return billing;
    }
}
