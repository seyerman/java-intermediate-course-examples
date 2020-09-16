package model;

public class Neighborhood implements Comparable<Neighborhood>{
	private String name;
	private double area;
	private int population;
	private int houses;
	private NeighborhoodType type;
	
	public Neighborhood(String n, double a, int p, int h, NeighborhoodType t) {
		name = n;
		area = a;
		population = p;
		houses = h;
		type = t;
	}
	
	public String getName() {
		return name;
	}
	public double getArea() {
		return area;
	}
	public int getPopulation() {
		return population;
	}
	public int getHouses() {
		return houses;
	}
	public NeighborhoodType getType() {
		return type;
	}

	@Override
	public int compareTo(Neighborhood otherNeigh) {
		int comp;
		if(area < otherNeigh.getArea()) {
			comp = 1;
		}else if(area > otherNeigh.getArea()) {
			comp = -1;
		}else if(population < otherNeigh.getPopulation()){
			comp = 1;
		}else if(population > otherNeigh.getPopulation()){
			comp = -1;
		}else {
			comp = 0;
		}
		return comp;
	}
	
	public int compareToByHousesAndPopulation(Neighborhood otherN) {
		int comp;
		comp = houses-otherN.getHouses();
		if(comp==0) {
			comp = population-otherN.getPopulation();
		}
		return comp;
	}
	
	public String toString() {
		return "\n"+name+","+area+","+population+","+houses+","+type;
	}
}
