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
 * Servlet implementation class EditDescriptionServlet
 */
@WebServlet("/editDescriptionServlet")
public class EditDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDescriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DescriptionHelper dh = new DescriptionHelper();
		
		String color = request.getParameter("color");
		String stringYear = request.getParameter("year");
		String stringAcquisitionDate = request.getParameter("acquisitionDate");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		LocalDate acquisitionDate = LocalDate.parse(stringAcquisitionDate);
		int year = Integer.parseInt(stringYear);
		
		Descriptions descriptionToUpdate = dh.searchForDescriptionsById(tempId);
		descriptionToUpdate.setColor(color);
		descriptionToUpdate.setYear(year);
		descriptionToUpdate.setAcquisitionDate(acquisitionDate);
		
		dh.updateDescriptions(descriptionToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllDescriptionsServlet").forward(request, response);
	}

}
