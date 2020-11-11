package model;

public class BounceProgressBar extends BasicProgress{
	private String widgetRight;
	private String widgetLeft;
	private int direction;
	private String bar;
	private int widgetPos;
	
	public final static int RIGHT = 1;
	public final static int LEFT = -1;
	
	public BounceProgressBar(int max, String wr, String wl) {
		super(max);
		init(wr,wl);
	}
	
	public BounceProgressBar(int max, String w) {
		super(max);
		init(w,w);
	}
	
	private void init(String wr,String wl) {
		widgetRight = wr;
		widgetLeft  = wl;
		widgetPos = 0;
		direction = RIGHT;
		bar = template.replaceFirst(getCharsString(widgetRight.length(),' '), widgetRight);
	}
	
	private String getCharsString(int n, char c) {
		String str = "";
		for (int i = 0; i < n; i++) {
			str += c;
		}
		return str;
	}
	
	@Override
	public void advance() {
		
	}

	@Override
	public String getState() {
		return bar;
	}

	@Override
	public boolean finished() {
		return true;
	}
}
