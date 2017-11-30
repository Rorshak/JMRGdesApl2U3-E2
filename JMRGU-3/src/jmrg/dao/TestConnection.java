package jmrg.dao;

import jmrg.model.Automovile;

public class TestConnection {
	public static void main(String[] args) {
		AutomovileDAOImpl automovileDAOImpl = new AutomovileDAOImpl();
		automovileDAOImpl.deleteAutomovile(1);
		//automovilDAOImpl.createAutomovil(new  Automovile( 1,"mercedes benz", "hola",2017));
	}
}
