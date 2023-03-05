package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InventoryDetails;

/**
 * Servlet implementation class InventoryDetailsNavigationServlet
 */
@WebServlet("/inventoryDetailsNavigationServlet")
public class InventoryDetailsNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryDetailsNavigationServlet() {
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
		// TODO Auto-generated method stub
				InventoryDetailsHelper ih = new InventoryDetailsHelper();
				String in = request.getParameter("doThisToInventory");

				if (in == null) {
					// no button has been selected
					getServletContext().getRequestDispatcher("/viewAllInventoriesServlet").forward(request, response);

				} else if (in.equals("delete")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));
						InventoryDetails inventoryToDelete = ih.searchForInventoryDetailsById(tempId);
						ih.deleteInventory(inventoryToDelete);

					} catch (NumberFormatException e) {
						System.out.println("No option was selected");
					} finally {
						getServletContext().getRequestDispatcher("/viewAllInventoriesServlet").forward(request, response);
					}

				} else if (in.equals("edit")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));
						InventoryDetails inventoryToEdit = ih.searchForInventoryDetailsById(tempId);
						request.setAttribute("rosterToEdit", inventoryToEdit);
						request.setAttribute("month", inventoryToEdit.getAcquisitionDate().getMonthValue());
						request.setAttribute("date", inventoryToEdit.getAcquisitionDate().getDayOfMonth());
						request.setAttribute("year", inventoryToEdit.getAcquisitionDate().getYear());
						DescriptionHelper allDescriptions = new DescriptionHelper();
						
						request.setAttribute("allPlayers", allDescriptions.showAllDescriptions());
									
						if(allDescriptions.showAllDescriptions().isEmpty()){
								request.setAttribute("allDescriptions", " ");
						}
						getServletContext().getRequestDispatcher("/edit-inventory.jsp").forward(request, response);
					} catch (NumberFormatException e) {
						getServletContext().getRequestDispatcher("/viewAllInventoriesServlet").forward(request, response);
					} 

				}
			}
}
