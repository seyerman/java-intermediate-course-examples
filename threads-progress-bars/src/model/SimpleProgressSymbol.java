package model;

public class SimpleProgressSymbol extends BasicProgress{
	private String currentState;
	
	public static final String[] states = {"|","/","-","\\"};
	
	public SimpleProgressSymbol(int max) {
		super(max);
		currentState = states[current];
	}
	
	@Override
	public void advance() {
		current = current+1;
		currentState = states[current % states.length];
	}
	
	@Override
	public String getState() {
		return "["+currentState+"]";
	}
	
	@Override
	public boolean finished() {
		return current>=maximum;
	}
}
