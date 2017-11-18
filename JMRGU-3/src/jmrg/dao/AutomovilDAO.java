package jmrg.dao;

import java.util.List;

import jmrg.model.Automovil;

public interface AutomovilDAO {
	void createAutomovil(Automovil automovil);
	Automovil readAutomovil(int id);
	List<Automovil> readAllAutomovils();
	void updateAutomovil(Automovil automovil);
	void deleteAutomovil(int id);
	
}
