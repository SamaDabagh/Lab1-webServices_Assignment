package webCourse;

import java.io.IOException;
import java.io.PrintStream;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebCourseServlet
 */
@WebServlet("/WebCourseServlet")
public class WebCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WebCourseServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Course[] courseRecords = new Course[7];
		courseRecords[0] = createCourseList("MIS_101","Intro.to.Info.Systems", 3	,140);
		courseRecords[1] = createCourseList("MIS_301","Systems.Analysis", 3	,35);
		courseRecords[2] = createCourseList("MIS_441","Database.Management", 3	,12);
		courseRecords[3] = createCourseList("CS_155","Programming.in.C++", 3	,90);
		courseRecords[4] = createCourseList("MIS_451","Web-Based.Systems", 3	,30);
		courseRecords[5] = createCourseList("MIS_551","Advanced.Web", 3	,30);
		courseRecords[6] = createCourseList("MIS_651","Advanced.Java", 3	,30);


		response.setContentType("text/html");
		PrintStream out = new PrintStream(response.getOutputStream());
		double TotalCourseFees = 0.00;
		out.println("<table border = 1 style=\"text-align: center; margin-top: 40px; margin-left: 35%;\"><tr>");
		out.println("<th style=\"padding: 10px;\"> Course No </th>"
					+ "<th style=\"padding: 10px;\">Course Name</th>"
					+ "<th style=\"padding: 10px;\">Max Enrlment</th>"
					+ "<th style=\"padding: 10px;\">Credits</th>"
					+ "<th style=\"padding: 10px;\">Total Course Fee</th></tr>"
					);
		for(int i  = 0 ; i < courseRecords.length ; i++) 
		{	out.println("<tr><td style=\"padding: 10px;\">" +courseRecords[i].getCourse_no()+ "</td>"
						+ "<td style=\"padding: 10px;\">" +courseRecords[i].getCourse_name()+"</td>"
						+ "<td style=\"padding: 10px;\">" +courseRecords[i].credit+"</td>"
						+ "<td style=\"padding: 10px;\">" +courseRecords[i].getMax_enrl()+"</td>"
						+ "<td style=\"padding: 10px;\">" +courseRecords[i].CalculateTotalFees()+" $</td></tr>"
						);
		TotalCourseFees += courseRecords[i].CalculateTotalFees();
		
		};
		out.println("</table>");
		out.println("<h2 style=\"text-align: center; margin-top: 40px; \">The Total of Course Fee is: "+TotalCourseFees+" $</h2>");
		 
		out.close();
		
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public Course createCourseList(String course_no, String course_name, int credit,int max_enrl)

	{
			Course myCourse = new Course();
			myCourse.setCourse_no(course_no);
			myCourse.setCourse_name(course_name);
            myCourse.credit = credit;
            myCourse.setMax_enrl(max_enrl);

		return myCourse;
	
	}
}
