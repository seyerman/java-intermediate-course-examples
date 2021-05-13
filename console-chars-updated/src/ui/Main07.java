package ui;

import java.io.IOException;

public class Main07 {
	public static void clrscr(){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}

	public static void main(String[] args) throws InterruptedException {
		StringBuilder str1 = new StringBuilder("[>========================]");
		StringBuilder str2 = new StringBuilder("[*========================]");
		int current = 1;
		int direction = 1;
		String symbol1 = ">";
		String symbol2 = "*";
		for (int i = 0; i < 1000; i++) {
			str1.replace(current, current+1, "=");
			str2.replace(current, current+1, "=");
			current+=direction;
			str1.replace(current, current+1, symbol1);
			str2.replace(current, current+1, symbol2);
			
			if(current==str1.length()-2) {
				symbol1 = "<";
				direction = -1;
			}
			if(current==1) {
				symbol1 = ">";
				direction = 1;
			}
			clrscr();
			System.out.print(str1+"\n"+str2+"\n");
			Thread.sleep(100);
		}
	}

}
