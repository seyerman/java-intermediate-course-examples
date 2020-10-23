package model;

public class LinkedList {
	private boolean evenSize;
	private Element first;
	private Element last;
	private Element median;
	
	public LinkedList() {
		evenSize = true;
	}
	
	public void addFirst(long num) {
		Element el = new Element(num);
		if(first==null) {
			first = el;
			last = el;
			median = el;
		}else {
			el.setNextElement(first);
			first.setPrevElement(el);
			first = el;
			
			if(!evenSize) {
				median = median.getPrevElement();
			}
		}
		
		evenSize = !evenSize;
	}
	
	public void addLast(long num) {
		Element el = new Element(num);
		if(last==null) {
			first = el;
			last = el;
			median = el;
		}else {
			el.setPrevElement(last);
			last.setNextElement(el);
			last = el;
			
			if(evenSize) {
				median = median.getNextElement();
			}
		}
		
		evenSize = !evenSize;		
	}
	
	public long getMedian() {
		return median.getNumber();
	}
	
	public String toString() {
		String msg = "";
		String sep = "";
		Element current = first;
		while(current!=null) {
			msg += sep+current;
			current = current.getNextElement();
			sep = "-";
		}
		return msg;
	}
}
