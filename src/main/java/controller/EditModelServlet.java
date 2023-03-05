package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Models;

/**
 * Servlet implementation class EditModelServlet
 */
@WebServlet("/editModelServlet")
public class EditModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditModelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelHelper mh = new ModelHelper();
		
		String name = request.getParameter("modelName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Models modelToUpdate = mh.searchForModelById(tempId);
		modelToUpdate.setModelName(name);
		
		mh.updateModel(modelToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllModelsServlet").forward(request, response);
	}
}
