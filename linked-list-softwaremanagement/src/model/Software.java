package model;

public class Software {
	private String name;
	private String developer;
	private String license;
	private Software nextSoft;
	
	public Software(String n, String d, String l) {
		name = n;
		developer = d;
		license = l;
		
		nextSoft = null;
	}

	public String getName() {
		return name;
	}

	public String getDeveloper() {
		return developer;
	}

	public String getLicense() {
		return license;
	}

	public Software getNextSoft() {
		return nextSoft;
	}
	
	public void setNextSoft(Software ns) {
		nextSoft = ns;
	}
}
