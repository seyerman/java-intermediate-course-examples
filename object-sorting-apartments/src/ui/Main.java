package ui;

import java.util.Arrays;

import model.Apartment;
import model.Condominium;

public class Main {

	public static void main(String[] args) {
		//objectSortingStrings();
		objectSortingApartments();
	}
	
	private static void objectSortingApartments() {
		Condominium condo = new Condominium();
		condo.getApartments().add(new Apartment(201, 'B', 65.3, 3, "SDD45"));
		condo.getApartments().add(new Apartment(104, 'B', 64.1, 2, "GFH56"));
		condo.getApartments().add(new Apartment(302, 'B', 67.2, 1, "JGDF2"));
		condo.getApartments().add(new Apartment(502, 'B', 65.3, 4, "VSFG5"));
		condo.getApartments().add(new Apartment(204, 'B', 65.5, 5, "UYRT4"));
		condo.getApartments().add(new Apartment(201, 'A', 68.7, 2, "ADF42"));
		condo.getApartments().add(new Apartment(104, 'E', 66.8, 4, "KGJ34"));
		condo.getApartments().add(new Apartment(201, 'D', 64.9, 2, "PYUY3"));
		condo.getApartments().add(new Apartment(104, 'A', 62.3, 1, "POI27"));
		
		System.out.println("Before Sorting");
		System.out.println(condo.getApartments());
		
		condo.sortByNumberAndBuilding();
		
		System.out.println("After Sorting by Number and Building");
		System.out.println(condo.getApartments());
		
		condo.sortByNomenclature();
		
		System.out.println("After Sorting by Nomenclature");
		System.out.println(condo.getApartments());
		
		condo.sortByArea();
		
		System.out.println("After Sorting by Area");
		System.out.println(condo.getApartments());
		
		condo.sortByPeopleAndNomenclature();
		
		System.out.println("After Sorting by People and Nomenclature");
		System.out.println(condo.getApartments());
		
		condo.sortByBuildingAndNumber();
		
		System.out.println("After Sorting by Building and Number");
		System.out.println(condo.getApartments());
	}

	public static void objectSortingStrings() {
		String[] strs = {
			"Juan",
			"Bibiana",
			"Adriana",
			"Luis",
			"Adrian",
			"José",
			"Pedro"
		};
		System.out.println("Before Sorting");
		System.out.println(Arrays.toString(strs));
		
		long start = System.currentTimeMillis();
		Arrays.sort(strs);
		long end = System.currentTimeMillis();
		System.out.println("After Sorting");
		System.out.println(Arrays.toString(strs));
		
		System.out.println("start:"+start);
		System.out.println("end:"+end);
		System.out.println("end-start:"+(end-start));
	}

}
