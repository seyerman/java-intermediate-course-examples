package model;

public class BounceProgressBar extends BasicProgress{
	private String widgetRight;
	private String widgetLeft;
	private String currentWidget;
	private int direction;
	private String bar;
	private int widgetPos;
	
	public final static int RIGHT = 1;
	public final static int LEFT = -1;
	
	public BounceProgressBar(int max, String wr, String wl, String templ) {
		super(max);
		init(wr,wl);
		template = templ;
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
		currentWidget = widgetRight;
		putWidget();
	}
	
	private void putWidget() {
		bar = template.substring(0, widgetPos+1)
			+ currentWidget
		    + template.substring(widgetPos+currentWidget.length()+1);
	}
	
	@Override
	public void advance() {
		if(current < maximum) {
			current++;
			widgetPos += direction;
			
			if(direction==RIGHT && widgetPos+widgetRight.length()>template.length()-2) {
				direction = LEFT;
				widgetPos += direction;
				currentWidget = widgetLeft;
			}
			if(direction==LEFT && widgetPos<0) {
				direction = RIGHT;
				widgetPos += direction;
				currentWidget = widgetRight;
			}
			
			putWidget();
		}
	}

	@Override
	public String getState() {
		return getStateWithPercentaje(bar);
	}
}
