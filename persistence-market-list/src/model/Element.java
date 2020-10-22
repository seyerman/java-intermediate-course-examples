package model;

import java.io.Serializable;

public class Element implements Serializable{
	public static final long serialVersionUID = 2;
	private String name;
	private double amount;
	private ExportPermit exportPermit;
	public Element(String name, double amount) {
		this.name = name;
		this.amount = amount;
		exportPermit = new ExportPermit("1", "");
	}
	public String getName() {
		return name;
	}
	public double getAmount() {
		return amount;
	}
	public ExportPermit getExportPermite() {
		return exportPermit;
	}
}
