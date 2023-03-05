package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Descriptions;
import model.InventoryDetails;
import model.Models;
/**
 * Servlet implementation class CreateNewInventoryServlet
 */
@WebServlet("/createNewInventoryServlet")
public class CreateNewInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DescriptionHelper dh = new DescriptionHelper();
		String inventoryName = request.getParameter("inventoryName");
		System.out.println("Inventory Name: " + inventoryName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String modelName = request.getParameter("modelName");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedDescriptions = request.getParameterValues("allDescriptionsToAdd");
		List<Descriptions> selectedDescriptionsInInventory = new ArrayList<Descriptions>();
		
		if(selectedDescriptions != null && selectedDescriptions.length > 0) {
			for(int i = 0; i < selectedDescriptions.length; i++) {
				Descriptions d = dh.searchForDescriptionsById(Integer.parseInt(selectedDescriptions[i]));
			}
		}
		
		Models models = new Models(modelName);
		InventoryDetails id = new InventoryDetails(inventoryName, ld, models);
		
		id.setListOfDescriptions(selectedDescriptionsInInventory);
		InventoryDetailsHelper idh = new InventoryDetailsHelper();
		idh.insertNewInventoryDetails(id);
		
		System.out.println("Success");
		System.out.println(id.toString());
		
		getServletContext().getRequestDispatcher("/viewAllInventoriesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
