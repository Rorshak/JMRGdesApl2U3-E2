package jmrg.report;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmrg.dao.AutomovileDAO;
import jmrg.dao.AutomovileDAOImpl;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class AutomovileReport
 */
@WebServlet("/AutomovileReport")
public class AutomovileReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AutomovileDAOImpl dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutomovileReport() {
        super();
        dao = new AutomovileDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "C:\\Users\\Home\\eclipse-workspace\\JMRGU-3\\src\\jmrg\\report\\automovil.jrxml";
		try {
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("logo_chema", this.getServletContext().getRealPath("/") + "images/logo_chema.jpg");
			data.put("logo_rock", this.getServletContext().getRealPath("/") + "images/logo_rock.jpg");

			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "utng",
					"mexico");
			JasperPrint print = JasperFillManager.fillReport(report, data,connection);
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (JRException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
