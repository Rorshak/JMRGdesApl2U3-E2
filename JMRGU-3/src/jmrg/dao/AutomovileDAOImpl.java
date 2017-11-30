/**
 * 
 */
package jmrg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jmrg.model.Automovile;


/**
 * @author Chema
 *
 */
public class AutomovileDAOImpl implements AutomovileDAO {
	private Connection connection;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;

	public AutomovileDAOImpl() {
		getConnection();
	}

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "utng", "mexico");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createAutomovile(Automovile automovile) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("INSERT INTO automovil (marca,modelo,year) values(?,?,?);");
				prepareStatement.setString(1, automovile.getMark());
				prepareStatement.setString(2, automovile.getModel());
				prepareStatement.setInt(3, automovile.getYear());
				
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Automovile readAutomovile(int id) {
		Automovile automovile = null;
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM automovil WHERE id=?;");
				prepareStatement.setInt(1, id);
				resultSet = prepareStatement.executeQuery();
				if (resultSet.next()) {
					automovile = new Automovile(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							 resultSet.getInt(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return automovile;
	}

	@Override
	public List<Automovile> readAllAutomovils() {
		List<Automovile> automoviles = new ArrayList<Automovile>();
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM automovil;");
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Automovile automovile = new Automovile(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							 resultSet.getInt(4));
					automoviles.add(automovile);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return automoviles;
	}

	@Override
	public void updateAutomovile(Automovile automovile) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("UPDATE automovil  SET marca = ?, modelo=?, year=?  WHERE id=?;");
				prepareStatement.setString(1, automovile.getMark());
				prepareStatement.setString(2, automovile.getModel());
				prepareStatement.setInt(3, automovile.getYear());
				prepareStatement.setInt(4, automovile.getId());
				prepareStatement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteAutomovile(int id) {
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("DELETE FROM automovil  WHERE id=?;");
				prepareStatement.setInt(1, id);
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



	

}
