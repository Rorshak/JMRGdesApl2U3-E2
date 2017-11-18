package jmrg.model;

public class Automovil {
	private int id;
	private String marca;
	private String modelo;
	private int year;
	public Automovil(int id, String marca, String modelo, int year) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.year = year;
	}
	public Automovil() {
		this(0, "","",0);
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the idAutomovil
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param idAutomovil the idAutomovil to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Automovil [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", year=" + year
				+ "]";
	}
	
	
	
}
