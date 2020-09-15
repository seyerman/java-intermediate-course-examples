package model;

import java.util.Comparator;

public class AreaComparator implements Comparator<Apartment>{

	@Override
	public int compare(Apartment o1, Apartment o2) {
		double a1 = o1.getArea();
		double a2 = o2.getArea();
		
		return (int)((a1-a2)*1000000);
	}

}
