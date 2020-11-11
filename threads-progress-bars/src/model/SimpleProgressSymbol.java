package model;

public class SimpleProgressSymbol implements ProgressGadget{
	private String currentState;
	private int currentPos;
	private int maximum;
	
	public static final String[] states = {"|","/","-","\\"};
	
	public SimpleProgressSymbol(int max) {
		currentPos = 0;
		maximum = max;
		currentState = states[currentPos];
	}
	
	@Override
	public void advance() {
		currentPos = currentPos+1;
		currentState = states[currentPos % states.length];
	}
	
	@Override
	public String getState() {
		return "["+currentState+"]";
	}
	
	@Override
	public boolean finished() {
		return currentPos>=maximum;
	}
}
