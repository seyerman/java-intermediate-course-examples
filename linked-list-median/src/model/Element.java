package model;

public class Element {
	private long number;
	private Element nextElement;
	private Element prevElement;
	
	public Element(long num) {
		number = num;
	}

	public Element getNextElement() {
		return nextElement;
	}

	public void setNextElement(Element ne) {
		nextElement = ne;
	}

	public Element getPrevElement() {
		return prevElement;
	}

	public void setPrevElement(Element pe) {
		prevElement = pe;
	}

	public long getNumber() {
		return number;
	}
	
	public String toString() {
		return number+"";
	}
}
