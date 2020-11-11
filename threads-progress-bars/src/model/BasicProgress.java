package model;

public abstract class BasicProgress  implements ProgressGadget{
	protected int current;
	protected int maximum;
	
	public BasicProgress(int max) {
		current = 0;
		maximum = max;
	}

	public String getPercentage() {
		return String.format("%3d",(int)(current*100.0/maximum));
	}
}
