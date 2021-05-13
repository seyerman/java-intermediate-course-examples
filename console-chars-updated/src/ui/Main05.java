package ui;

public class Main05 {
	public static void main(String[] args) throws InterruptedException {
        String[] spinner = new String[] {"/", "-", "\\", "|" };
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(150);
            System.out.print("\r["+spinner[i % spinner.length]+"]");
        }
    }
}
