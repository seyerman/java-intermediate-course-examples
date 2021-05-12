package ui;

import java.io.IOException;

public class Main4 {
	public static void clrscr(){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
	
	public static void main(String[] args) {
		System.out.println("Hallo \033[32mgreen\033[0m-text.");
		//System.out.print("\u001b[31mHello, World!");
		//System.out.println ((char)27 + "[2J");
		System.out.print("\033[H\033[2J");  
	    //System.out.flush();
		//System.out.println("asdfadfa\nsafasdf\nasdfafasfa");
		//clrscr();
		System.out.print("Erase una vez\n");
		System.out.print("Un gato loco que\n");
		System.out.print("Andaba por ahí\n");
		System.out.print("Haciendo de las suyas\n");
		System.out.print("Travesura tras travesura");
		System.out.print("\b");
		System.out.print("\b");
		System.out.print("\b");
		System.out.print("\b");
		System.out.print("\b");
		System.out.print("\b");
		System.out.print("\b");
		System.out.print("\b");
		System.out.print("\b");
		System.out.print("tasdfasdf\n");
		System.out.print("\f");
		//clrscr();
		//final String ESC = "\033[";
		//System.out.print(ESC + "2J"); 
		//System.out.print(String.format("\033[2J"));
	}
}
