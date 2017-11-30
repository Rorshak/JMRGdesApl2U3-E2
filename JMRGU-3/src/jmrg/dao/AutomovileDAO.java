package jmrg.dao;

import java.util.List;

import jmrg.model.Automovile;

public interface AutomovileDAO {
	void createAutomovile(Automovile automovile);
	Automovile readAutomovile(int id);
	List<Automovile> readAllAutomovils();
	void updateAutomovile(Automovile automovile);
	void deleteAutomovile(int id);
	
}
