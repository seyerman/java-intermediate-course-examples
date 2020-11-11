package model;

public class RotateProgressBar extends SimpleProgressBar{
	private char[] currentChars;
	private int currentCurrentChar; 
	
	public RotateProgressBar(int max, char fill, char[] currCh) {
		super(max, fill);
		currentChars = currCh;
		currentCurrentChar = 0;
	}
	
	protected String getCurrentChar() {
		currentCurrentChar = (currentCurrentChar+1)%currentChars.length;
		char currCh = currentChars[currentCurrentChar];
		
		String ch = currCh + "";
		if(currCh=='\\') {
			ch = currCh + "\\";
		}
		
		return ch;
	}	
}
