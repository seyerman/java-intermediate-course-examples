package ui;

public class Main2 {
	public static void main(String[] args) throws InterruptedException {
        String[] spinner = new String[] {"\u0008/", "\u0008-", "\u0008\\", "\u0008|" };
        System.out.print("|");
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(150);
            System.out.print(spinner[i % spinner.length]);
        }
    }
}
