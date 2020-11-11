package model;

public class BounceProgressBar extends BasicProgress{
	private String widgetRight;
	private String widgetLeft;
	private int direction;
	
	public BounceProgressBar(int max) {
		super(max);
	}
	
	@Override
	public void advance() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean finished() {
		// TODO Auto-generated method stub
		return false;
	}
}
