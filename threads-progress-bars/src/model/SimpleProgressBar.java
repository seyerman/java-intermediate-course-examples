package model;

public class SimpleProgressBar implements ProgressGadget{
	public String bar;
	public int maximum;
	public int current;
	
	public String template = "[                         ]";
	
	public SimpleProgressBar(int max) {
		bar = template;
		current = 0;
		maximum = max;
	}
	
	@Override
	public void advance() {
		if(current < maximum) {
			current++;
			
			int numberBarChars = template.length()-2;
			int numberFilledChars = (int)((current/(double)maximum)*numberBarChars);
			bar = template;
			for (int i = 0; i < numberFilledChars; i++) {
				bar = bar.replaceFirst(" ", "#");				
			}
		}
	}
	
	private String getPercent() {
		return String.format("%3d",(int)(current*100.0/maximum));
	}

	@Override
	public String getState() {
		return bar+getPercent()+"%";
	}
	
	@Override
	public boolean finished() {
		return current>=maximum;
	}
}
