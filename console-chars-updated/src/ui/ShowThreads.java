package ui;
import java.util.Random;

/**---------------------------------------------------------------
 * Demo of simple thread class
 * Last Modified: March 2008
 * @author Michael B. Feldman, mfeldman at gwu.edu
 *--------------------------------------------------------------*/

public class ShowThreads {

	public static void main(String args[]) {
		SimpleThread ThreadA = new SimpleThread("A", 5, 1);
		SimpleThread ThreadB = new SimpleThread("B", 7, 21);
		SimpleThread ThreadC = new SimpleThread("C", 4, 41);

		SafeScreen.clearScreen();
		ThreadA.start();
		ThreadB.start();
		ThreadC.start();
	}

} // end ShowThreads

/**---------------------------------------------------------------
 * Simple Java thread example
 * Last Modified: March 2008
 * @author Michael B. Feldman, mfeldman at gwu.edu
 *--------------------------------------------------------------*/

class SimpleThread extends Thread {

	private static final Random random = new Random();
	private String name = "Default";
	private int count = 0;
	private int column = 0;

	// constructor
	public SimpleThread(String name, int count, int column) {
		this.name = name;
		this.count = count;
		this.column = column;
	}

	// run method invoked when 'start' called
	public void run() {
		for(int i = 1; i <= count; i++) {
			int nap = random.nextInt(7) + 1;
			SafeScreen.write(name + " naps " + nap + " secs", i, column);
			try {
				sleep(nap * 1000);
			}
			catch(InterruptedException e) {} // ignored
		}
	}

} // end class SimpleThread

/**---------------------------------------------------------------
 * Thread-safe Mini-terminal controller for vt100 (ANSI) terminals
 * Translated from C to Java February 2001
 * @author Michael B. Feldman, mfeldman at gwu.edu
 *--------------------------------------------------------------*/

class SafeScreen {

	public static synchronized void clearScreen() {
		System.out.print("\033" + "[2J");
	}

	public static synchronized void write(
			String item, int row, int col) {
		System.out.println("\033" + "[" + row + ";" + col + "f" + item);
	}

} // End of class SafeScreen