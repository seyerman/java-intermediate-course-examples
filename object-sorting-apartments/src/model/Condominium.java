package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Condominium {
	private List<Apartment> apartments;
	public Condominium() {
		apartments = new ArrayList<>();
	}
	
	public List<Apartment> getApartments(){
		return apartments;
	}
	
	public void sortByNumberAndBuilding() {
		Collections.sort(apartments);
	}
	
	public void sortByNomenclature() {
		NomenclatureComparator nc = new NomenclatureComparator();
		Collections.sort(apartments,nc);
	}
	
	public void sortByArea() {
		Collections.sort(apartments,new AreaComparator());
	}
}
