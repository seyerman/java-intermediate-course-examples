package model;

public class Player {
	private int shirtNumber;
	private String fullName;
	private String positionName;

	public Player(int sn, String fn, String pn) {
		shirtNumber  = sn;
		fullName     = fn;
		positionName = pn;
	}
	
	public int getShirtNumber() {
		return shirtNumber;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String getPositionName() {
		return positionName;
	}	
	
	public String toString() {
		String m;
		m = shirtNumber+", "+fullName+", "+positionName;
		return m;
	}
}
