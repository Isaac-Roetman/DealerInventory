package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Models;
/**
 * Servlet implementation class ModelNavigationServlet
 */
@WebServlet("/modelNavigationServlet")
public class ModelNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModelNavigationServlet() {
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
		String in = request.getParameter("doThisToModel");
		ModelHelper mh  = new ModelHelper();
		
		String path = "/viewAllModelsServlet";
		
		if(in.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Models modelToDelete = mh.searchForModelById(tempId);
				mh.deleteModel(modelToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Did not select a model");
			}
		} else if (in.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Models modelToEdit = mh.searchForModelById(tempId);
				request.setAttribute("modelToEdit", modelToEdit);
				path = "/edit-model.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Did not select a model");
			}
		} else if (in.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
