package model;

import java.util.Comparator;

public class NameComparator implements Comparator<Neighborhood>{

	@Override
	public int compare(Neighborhood o1, Neighborhood o2) {
		int comp;
		String n1 = o1.getName();
		String n2 = o2.getName();
		
		comp = n1.compareTo(n2);
		
		return comp;
	}

}
