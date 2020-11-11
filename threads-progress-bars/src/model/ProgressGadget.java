package model;

public interface ProgressGadget {
	public static final String template = "[                 ]";	
	public void advance();
	public String getState();
	public boolean finished();
	public String getPercentage();
}
