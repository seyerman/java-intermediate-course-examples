package model;

public class SimpleProgressSymbol {
	private String currentState;
	private int currentPos;
	
	public static final String[] states = {"|","/","-","\\"};
	
	public SimpleProgressSymbol() {
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
