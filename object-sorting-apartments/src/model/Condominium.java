package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	public void sortByPeopleAndNomenclature() {
		for (int i = 1; i < apartments.size(); i++) {
			Apartment api = apartments.get(i);
			int j = i;
			Apartment apj = apartments.get(j-1);
			while(j>0 && api.compareToByPeopleAndNomenclature(apj)<0) {
				apartments.set(j,apj);
				j--;
				if(j>0) apj = apartments.get(j-1);
			}
			apartments.set(j,api);
		}
	}
	
	public void sortByBuildingAndNumber() {
		Comparator<Apartment> ca = new Comparator<Apartment>() {
			public int compare(Apartment a1, Apartment a2) {
				int comp;
				
				comp = a1.getBuilding()-a2.getBuilding();
				
				if(comp==0) {
					comp = a1.getNumber()-a2.getNumber();
				}
				
				return comp;
			}
		};
		
		Collections.sort(apartments,ca);
	}
}
