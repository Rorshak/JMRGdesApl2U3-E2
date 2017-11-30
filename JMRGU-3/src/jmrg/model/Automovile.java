package jmrg.model;

public class Automovile {
	private int id;
	private String mark;
	private String model;
	private int year;
	public Automovile(int id, String mark, String model, int year) {
		super();
		this.id = id;
		this.mark = mark;
		this.model = model;
		this.year = year;
	}
	public Automovile() {
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
	 * @return the mark
	 */
	public String getMark() {
		return mark;
	}
	/**
	 * @param mark the mark to set
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
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
		return "Automovile [id=" + id + ", mark=" + mark + ", model=" + model + ", year=" + year
				+ "]";
	}
	
	
	
}
