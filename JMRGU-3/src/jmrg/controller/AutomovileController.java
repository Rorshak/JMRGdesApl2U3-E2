	package jmrg.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jmrg.dao.AutomovileDAO;
import jmrg.dao.AutomovileDAOImpl;
import jmrg.model.Automovile;

;

/**
 * Servlet implementation class AutomovileController
 */
@WebServlet("/AutomovileController")
public class AutomovileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Automovile automovile;
	private List<Automovile> automoviles;
	private AutomovileDAO automovileDAO;
	private List<String> ids = new ArrayList<String>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutomovileController() {
    	 automovile = new Automovile();
         automoviles = new ArrayList<Automovile>();
         automovileDAO = new AutomovileDAOImpl();
   		 // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {
			automovile.setMark(request.getParameter("mark"));
			automovile.setModel(request.getParameter("model"));
			automovile.setYear(Integer.parseInt(request.getParameter("year")));
			
			
			System.out.println("save");
			if (automovile.getId()==0) {
				System.out.println("save");
				automovileDAO.createAutomovile(automovile);
			} else {
				System.out.println("save");
				automovileDAO.updateAutomovile(automovile);
			}
			automoviles = automovileDAO.readAllAutomovils();
			request.setAttribute("automoviles", automoviles);
			request.getRequestDispatcher("automovile_list.jsp").forward(request, response);
		}else if(request.getParameter("btn_new")!=null) {
			automovile = new Automovile();
			request.getRequestDispatcher("automovile_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_edit")!=null) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				automovile = automovileDAO.readAutomovile(id);	
			}catch (IndexOutOfBoundsException e) {
				automovile = new Automovile();
			}
		 request.setAttribute("automovile", automovile);
		 request.getRequestDispatcher("automovile_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				automovileDAO.deleteAutomovile(id);
				automoviles = automovileDAO.readAllAutomovils();
			}catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("automoviles", automoviles);
			request.getRequestDispatcher("automovile_list.jsp").forward(request, response);
		}else {
			automoviles = automovileDAO.readAllAutomovils();
			request.setAttribute("automoviles", automoviles);
			request.getRequestDispatcher("automovile_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
