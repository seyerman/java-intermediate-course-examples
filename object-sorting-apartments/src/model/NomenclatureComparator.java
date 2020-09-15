package model;

import java.util.Comparator;

public class NomenclatureComparator implements Comparator<Apartment>{

	@Override
	public int compare(Apartment apt1, Apartment apt2) {
		int comp;
		String nom1 = apt1.getNomenclature(); 
		String nom2 = apt2.getNomenclature(); 
		
		comp = nom1.compareTo(nom2);
		
		return comp;
	}
}
