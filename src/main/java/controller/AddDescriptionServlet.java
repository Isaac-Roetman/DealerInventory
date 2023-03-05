package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Descriptions;

/**
 * Servlet implementation class AddDescriptionServlet
 */
@WebServlet("/addDescriptionServlet")
public class AddDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDescriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = request.getParameter("color");
		String stringYear = request.getParameter("year");
		String stringAcquisitionDate = request.getParameter("acquisitionDate");
		
		LocalDate acquisitionDate = LocalDate.parse(stringAcquisitionDate);
		int year = Integer.parseInt(stringYear);
		
		Descriptions d = new Descriptions(color, year, acquisitionDate);
		DescriptionHelper dh = new DescriptionHelper();
		dh.insertDescription(d);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
