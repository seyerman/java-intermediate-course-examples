package model;

import java.util.ArrayList;
import java.util.Collections;
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
}
