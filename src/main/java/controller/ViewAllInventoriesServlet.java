package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InventoryDetails;
/**
 * Servlet implementation class ViewAllInventoriesServlet
 */
@WebServlet("/viewAllInventoriesServlet")
public class ViewAllInventoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllInventoriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InventoryDetailsHelper ih = new InventoryDetailsHelper();
		List<InventoryDetails> inventoryList = ih.getInventories();
		request.setAttribute("allInventories", inventoryList);
		
		if(inventoryList.isEmpty()) {
			request.setAttribute("allInventories", "");
			
		}
		
		getServletContext().getRequestDispatcher("/inventory-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
