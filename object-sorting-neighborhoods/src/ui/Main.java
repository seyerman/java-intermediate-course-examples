package ui;

import java.util.Arrays;

import model.Neighborhood;
import model.NeighborhoodType;
import model.Town;

public class Main {

	public static void main(String[] args) {
		//sortingStrings();
		sortingNeighborhoods();
	}

	private static void sortingNeighborhoods() {
		Town t = new Town();
		t.getNeighborhoods().add(new Neighborhood("Ciudad Jardín", 345.5, 845678, 876, NeighborhoodType.RESIDENTIAL));
		t.getNeighborhoods().add(new Neighborhood("El Ingenio", 345.5, 23456, 236, NeighborhoodType.RESIDENTIAL));
		t.getNeighborhoods().add(new Neighborhood("El Olímpico", 853.5, 876543, 764, NeighborhoodType.RESIDENTIAL));
		t.getNeighborhoods().add(new Neighborhood("Ciudad Córdoba", 345.8, 98236, 1259, NeighborhoodType.RESIDENTIAL));
		t.getNeighborhoods().add(new Neighborhood("Valle del Lili", 655.2, 78452, 876, NeighborhoodType.RESIDENTIAL));
		t.getNeighborhoods().add(new Neighborhood("Bochalema", 345.5, 46893, 924, NeighborhoodType.RESIDENTIAL));
		t.getNeighborhoods().add(new Neighborhood("Calicanto", 876.6, 267768, 4974, NeighborhoodType.RESIDENTIAL));
		t.getNeighborhoods().add(new Neighborhood("Granada", 453.1, 9442, 764, NeighborhoodType.RESIDENTIAL));
		t.getNeighborhoods().add(new Neighborhood("La Flora", 876.6, 2476, 2387, NeighborhoodType.RESIDENTIAL));
		t.getNeighborhoods().add(new Neighborhood("Melendez", 236.5, 5787, 876, NeighborhoodType.RESIDENTIAL));
		
		System.out.println("Before sorting");
		System.out.println(t.getNeighborhoods());

		t.sortByAreaAndPopulation();
		
		System.out.println("After sorting by Area and Population");
		System.out.println(t.getNeighborhoods());		

		t.sortByName();
		
		System.out.println("After sorting by Name");
		System.out.println(t.getNeighborhoods());		

		t.sortByHousesAndPopulation();
		
		System.out.println("After sorting by Houses and Population");
		System.out.println(t.getNeighborhoods());
		
		t.sortByPopulationAndHouses();
		
		System.out.println("After sorting by Population and Houses");
		System.out.println(t.getNeighborhoods());
	}

	public static void sortingStrings() {
		String[] brands = {
				"Dell",
				"HP",
				"Asus",
				"Mac",
				"Lenovo",
				"Toshiba",
				"Acer"
		};
		System.out.println("Before sorting");
		System.out.println(Arrays.toString(brands));
		
		Arrays.sort(brands);
		
		System.out.println("After sorting");
		System.out.println(Arrays.toString(brands));
	}

}
