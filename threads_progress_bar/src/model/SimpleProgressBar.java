package model;

public class SimpleProgressBar {
	private String currentState;
	private int currentPos;
	
	public static final String[] states = {"|","\\","-","/"};
	
	public SimpleProgressBar() {
		currentPos = 0;
		currentState = states[currentPos];
	}
	
	public void advance() {
		currentPos = (currentPos+1) % states.length;
		currentState = states[currentPos];
	}
	
	public String getState() {
		return currentState;
	}
}
