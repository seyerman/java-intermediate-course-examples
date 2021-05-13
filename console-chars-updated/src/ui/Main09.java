package ui;

public class Main09 {

	public static void main(String[] args) throws InterruptedException {
		StringBuilder str1 = new StringBuilder("[>========================]");
		StringBuilder str2 = new StringBuilder("[*------------------------]");
		int current1 = 1;
		int current2 = 1;
		int direction1 = 1;
		int direction2 = 1;
		String symbol1 = ">";
		String symbol2 = "*";
		for (int i = 0; i < 1000; i++) {
			str1.replace(current1, current1+1, "=");
			str2.replace(current2, current2+1, "-");
			current1+=direction1;
			current2+=direction2;
			str1.replace(current1, current1+1, symbol1);
			str2.replace(current2, current2+1, symbol2);
			
			if(current1==str1.length()-2) {
				symbol1 = "<";
				direction1 = -1;
			}
			if(current2==str1.length()-2) {
				direction2 = -2;
			}
			if(current1==1) {
				symbol1 = ">";
				direction1 = 1;
			}
			if(current2==1) {
				direction2 = 2;
			}
			System.out.print("\r"+str1+" "+str2);
			Thread.sleep(100);
		}
	}

}
