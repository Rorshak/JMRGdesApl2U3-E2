package jmrg.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jmrg.dao.AutomovilDAO;
import jmrg.dao.AutomovilDAOImpl;
import jmrg.model.Automovil;

;

/**
 * Servlet implementation class AutomovilController
 */
@WebServlet("/AutomovilController")
public class AutomovilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Automovil automovil;
	private List<Automovil> automovils;
	private AutomovilDAO automovilDAO;
	private List<String> ids = new ArrayList<String>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutomovilController() {
    	 automovil = new Automovil();
         automovils = new ArrayList<Automovil>();
         automovilDAO = new AutomovilDAOImpl();
   		 // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {
			automovil.setMarca(request.getParameter("marca"));
			automovil.setModelo(request.getParameter("modelo"));
			automovil.setYear(Integer.parseInt(request.getParameter("year")));
			
			
			System.out.println("save");
			if (automovil.getId()==0) {
				System.out.println("save");
				automovilDAO.createAutomovil(automovil);
			} else {
				System.out.println("save");
				automovilDAO.updateAutomovil(automovil);
			}
			automovils = automovilDAO.readAllAutomovils();
			request.setAttribute("automovils", automovils);
			request.getRequestDispatcher("automovil_list.jsp").forward(request, response);
		}else if(request.getParameter("btn_new")!=null) {
			automovil = new Automovil();
			request.getRequestDispatcher("automovil_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_edit")!=null) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				automovil = automovilDAO.readAutomovil(id);	
			}catch (IndexOutOfBoundsException e) {
				automovil = new Automovil();
			}
		 request.setAttribute("automovil", automovil);
		 request.getRequestDispatcher("automovil_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				automovilDAO.deleteAutomovil(id);
				automovils = automovilDAO.readAllAutomovils();
			}catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("automovils", automovils);
			request.getRequestDispatcher("automovil_list.jsp").forward(request, response);
		}else {
			automovils = automovilDAO.readAllAutomovils();
			request.setAttribute("automovils", automovils);
			request.getRequestDispatcher("automovil_list.jsp").forward(request, response);
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
