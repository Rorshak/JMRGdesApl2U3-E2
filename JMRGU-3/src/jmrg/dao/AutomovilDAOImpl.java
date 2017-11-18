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

import jmrg.model.Automovil;


/**
 * @author Chema
 *
 */
public class AutomovilDAOImpl implements AutomovilDAO {
	private Connection connection;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;

	public AutomovilDAOImpl() {
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
	public void createAutomovil(Automovil automovil) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("INSERT INTO automovil (marca,modelo,year) values(?,?,?);");
				prepareStatement.setString(1, automovil.getMarca());
				prepareStatement.setString(2, automovil.getModelo());
				prepareStatement.setInt(3, automovil.getYear());
				
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Automovil readAutomovil(int id) {
		Automovil automovil = null;
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM automovil WHERE id=?;");
				prepareStatement.setInt(1, id);
				resultSet = prepareStatement.executeQuery();
				if (resultSet.next()) {
					automovil = new Automovil(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							 resultSet.getInt(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return automovil;
	}

	@Override
	public List<Automovil> readAllAutomovils() {
		List<Automovil> automovils = new ArrayList<Automovil>();
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM automovil;");
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Automovil automovil = new Automovil(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
							 resultSet.getInt(4));
					automovils.add(automovil);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return automovils;
	}

	@Override
	public void updateAutomovil(Automovil automovil) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("UPDATE automovil  SET marca = ?, modelo=?, year=?  WHERE id=?;");
				prepareStatement.setString(1, automovil.getMarca());
				prepareStatement.setString(2, automovil.getModelo());
				prepareStatement.setInt(3, automovil.getYear());
				prepareStatement.setInt(4, automovil.getId());
				prepareStatement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteAutomovil(int id) {
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
