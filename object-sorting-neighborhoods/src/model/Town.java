package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Town {
	private List<Neighborhood> neighs;
	public Town() {
		neighs = new ArrayList<>();
	}
	public List<Neighborhood> getNeighborhoods(){
		return neighs;
	}
	public void sortByAreaAndPopulation() {
		Collections.sort(neighs);
	}
	public void sortByName() {
		NameComparator nc = new NameComparator();
		Collections.sort(neighs,nc);
	}
	public void sortByHousesAndPopulation() {
		for (int i = 0; i < neighs.size()-1; i++) {
			for (int j = 0; j < neighs.size()-i-1; j++) {
				Neighborhood n1 = neighs.get(j);
				Neighborhood n2 = neighs.get(j+1);
				if(n1.compareToByHousesAndPopulation(n2)>0) {
					neighs.set(j, n2);
					neighs.set(j+1, n1);
				}
			}
		}
	}
	
	public void sortByPopulationAndHouses() {
		Comparator<Neighborhood> cn;
		
		cn = new Comparator<Neighborhood>() {			
			public int compare(Neighborhood n1, Neighborhood n2) {
				int comp;
				comp = n1.getPopulation()-n2.getPopulation();
				if(comp==0) {
					comp = n1.getHouses()-n2.getHouses();
				}
				return comp;
			}
		};
		
		Collections.sort(neighs,cn);
	}
}
