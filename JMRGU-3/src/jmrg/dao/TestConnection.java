package jmrg.dao;

import jmrg.model.Automovil;

public class TestConnection {
	public static void main(String[] args) {
		AutomovilDAOImpl automovilDAOImpl = new AutomovilDAOImpl();
		automovilDAOImpl.deleteAutomovil(1);
		//automovilDAOImpl.createAutomovil(new  Automovil( 1,"mercedes benz", "hola",2017));
	}
}
