package model;

public class SimpleProgressBar implements ProgressGadget{
	private String bar;
	private int maximum;
	private int current;
	private char filling;
	private char currentChar;
	
	public String template = "[                 ]";
	
	public SimpleProgressBar(int max, char fill, char currCh) {
		init(max, fill, currCh);
	}
	
	public SimpleProgressBar(int max, char fill) {
		init(max, fill, fill);
	}
	
	private void init(int max, char fill, char currCh) {
		bar = template;
		filling = fill;
		currentChar = currCh;
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
				bar = bar.replaceFirst(" ", filling+"");				
			}
			bar = bar.replaceFirst(" ", currentChar+"");
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
