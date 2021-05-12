package ui;

public class Main6 {

	public static void main(String[] args) throws InterruptedException {
		StringBuilder str = new StringBuilder("[>========================]");
		int current = 1;
		int direction = 1;
		String symbol = ">";
		for (int i = 0; i < 1000; i++) {
			str.replace(current, current+1, "=");
			current+=direction;
			str.replace(current, current+1, symbol);
			
			if(current==str.length()-2) {
				symbol = "<";
				direction = -1;
			}
			if(current==1) {
				symbol = ">";
				direction = 1;
			}
			System.out.print("\r"+str);
			Thread.sleep(100);
		}
	}

}
