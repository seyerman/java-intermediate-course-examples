package model;

public class Apartment implements Comparable<Apartment>{
	private int number;
	private char building;
	private double area;
	private int people;
	private String nomenclature;
	
	public Apartment(int n,char b, double a,int p,String nom) {
		number = n;
		building = b;
		area = a;
		people = p;
		nomenclature = nom;
	}
	
	public int getNumber() {
		return number;
	}
	public char getBuilding() {
		return building;
	}
	public double getArea() {
		return area;
	}
	public int getPeople() {
		return people;
	}
	public String getNomenclature() {
		return nomenclature;
	}

	@Override
	public int compareTo(Apartment otherAp) {
		int comp;
		if(number<otherAp.getNumber()) {
			comp = -1; 
		}else if(number>otherAp.getNumber()) {
			comp = 1;
		}else {
			comp = compareByBuilding(otherAp);
		}
		return comp;
	}
	
	private int compareByBuilding(Apartment otAp) {
		int comp;
		if(building<otAp.getBuilding()) {
			comp = -1;
		}else if(building>otAp.getBuilding()) {
			comp = 1;
		}else {
			comp = 0;
		}
		return comp;
	}
	
	public String toString() {
		return "\n"+number+building+","+area+","+people+","+nomenclature;
	}
}
