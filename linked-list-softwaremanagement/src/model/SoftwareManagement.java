package model;

public class SoftwareManagement {
	private Software firstSoft;
	
	public SoftwareManagement() {
		firstSoft = null;
	}
	
	public Software getFirstSoft() {
		return firstSoft;
	}
	
	//add at end of list
	public void addSoft(String n, String d, String l) {
		Software newSoft = new Software(n,d,l);
		if(firstSoft==null) {
			firstSoft = newSoft;
		}else {
			Software current = firstSoft;
			while(current.getNextSoft()!=null) {
				current = current.getNextSoft();
			}
			current.setNextSoft(newSoft);
		}
	}
	
	public Software searchSoft(String n) {
		Software s = null;
		
		Software current = firstSoft;
		while(current!=null && s==null) {
			if(n.equals(current.getName())) {
				s = current;
			}
			current = current.getNextSoft();
		}
		
		return s;
	}
	
	public Software removeSoft(String n) {
		Software s = null;
		
		if(firstSoft!=null) {
			if(n.equals(firstSoft.getName())) {
				s = firstSoft;
				firstSoft = firstSoft.getNextSoft();
			}else {
			
				Software current = firstSoft;
				while(current.getNextSoft()!=null 
						&& !n.equals(current.getNextSoft().getName())) {
					current = current.getNextSoft();
				}
				
				if(current.getNextSoft()!=null) { //current is before
					current.setNextSoft(current.getNextSoft().getNextSoft());
				}
			}
		}
		
		return s;
	}
	
}
