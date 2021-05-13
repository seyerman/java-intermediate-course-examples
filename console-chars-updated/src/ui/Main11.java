package ui;

public class Main11 {
	
	public final static String ESC   = "\u001b[";
	public final static String UP    = ESC+"A";
	public final static String DOWN  = ESC+"B";
	public final static String RIGHT = ESC+"C";
	public final static String LEFT  = ESC+"D";
	public final static String NXLN  = ESC+"1E";
	
	public final static int[] TEXT_FORMAT = new int[] 
			{0,1,22,4,24,27,31,32,33,34,35,36,37,
			 40,41,42,43,44,45,46,47,48,90,91,92,93,94,
			 95,96,97,100,101,102,103,104,105,106,107};

	public static void main(String[] args) throws InterruptedException {
		char ch = '*';
		int sleep = 50;
		int width = 1;
		int max = 30;
		int color = 0;
		boolean mode = true;
		String dir1 = DOWN;
		String dir2 = LEFT;
		
		System.out.print(ESC+"2J");//Clear screen
		System.out.print(ESC+"0G"+ESC+"0d");//Cursor in 0,0
		
		System.out.print(ESC+TEXT_FORMAT[color]+"m"+ch);
		Thread.sleep(sleep);
		while(width<max) {
			width++;
			color = (color+1)%TEXT_FORMAT.length;
			String pass = "";
			for (int i = 0; i < width; i++) {
				System.out.print(pass);
				System.out.print(ESC+TEXT_FORMAT[color]+"m"+ch);
				Thread.sleep(sleep);
				System.out.print(LEFT);
				pass = dir1;
			}
			for (int i = 1; i < width; i++) {
				System.out.print(dir2);
				System.out.print(ESC+TEXT_FORMAT[color]+"m"+ch);
				Thread.sleep(sleep);
				System.out.print(LEFT);
			}
			mode = !mode;
			if(mode) {
				System.out.print(RIGHT);
				dir1 = DOWN;
				dir2 = LEFT;
			}else {
				System.out.print(DOWN);
				dir1 = RIGHT;
				dir2 = UP;				
			}
		}
	}

}
