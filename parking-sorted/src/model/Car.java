package model;

public class Car {
	private int id;
	private int model;
	private String color;
	
	public Car(int i, int m, String c) {
		id = i;
		model = m;
		color = c;
	}

	public int getId() {
		return id;
	}

	public int getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}
	
	public String toString() {
		return id+", "+model+", "+color;
	}
}
