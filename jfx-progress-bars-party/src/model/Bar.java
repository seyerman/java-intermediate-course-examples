package model;

public class Bar {
	public final static int MAX_LEVEL = 400;
	private int number;
	private int progressLevel;
	private int time;
	private boolean active;
	public Bar(int num, int t) {
		number = num;
		time = t;
		progressLevel = 0;
		active = true;
	}
	
	public int getProgressLevel() {
		return progressLevel;
	}
	
	public void advance() {
		if(progressLevel>=MAX_LEVEL) {
			active = false;
		}else {
			progressLevel++;
		}
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setActive(boolean act) {
		active = act;
	}
	
	public boolean isActive() {
		return active;
	}
}
