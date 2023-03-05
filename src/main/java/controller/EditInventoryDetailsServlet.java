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
 * Servlet implementation class EditInventoryDetailsServlet
 */
@WebServlet("/editInventoryDetailsServlet")
public class EditInventoryDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInventoryDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InventoryDetailsHelper ih = new InventoryDetailsHelper();
		DescriptionHelper dh = new DescriptionHelper();
		ModelHelper mh = new ModelHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		InventoryDetails inventoryToUpdate = ih.searchForInventoryDetailsById(tempId);
		
		String newInventoryName = request.getParameter("inventoryName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String modelName = request.getParameter("modelName");
		Models newModel = mh.findModel(modelName);
		
		LocalDate ad;
		
		try {
			ad = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			ad = LocalDate.now();
		}
		
		try {
			String[] selectedDescriptions = request.getParameterValues("allDescriptionsToAdd");
			List<Descriptions> selectedDescriptionsInList = new ArrayList<Descriptions>();
			
			for (int i = 0; i < selectedDescriptions.length; i++) {
				System.out.println(selectedDescriptions[i]);
				Descriptions d = dh.searchForDescriptionsById(Integer.parseInt(selectedDescriptions[i]));
				selectedDescriptionsInList.add(d);
			}
			inventoryToUpdate.setListOfDescriptions(selectedDescriptionsInList);
		} catch (NullPointerException e) {
			List<Descriptions> selectedDescriptionsInList = new ArrayList<Descriptions>();
			inventoryToUpdate.setListOfDescriptions(selectedDescriptionsInList);
		}
		
		inventoryToUpdate.setInventoryName(newInventoryName);
		inventoryToUpdate.setAcquisitionDate(ad);
		inventoryToUpdate.setModels(newModel);
		
		ih.updateInventory(inventoryToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllInventoriesServlet").forward(request, response);
	}

}
