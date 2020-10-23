package ui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/inputGenerated.txt"));
		int n = 10000000;
		//int opRep = 1000;
		long interval = 100000000000L;
		
		bw.write(n+"\n");
		
		long lastLeft  = 500000000000000000L;	
		long lastRight = 500000000000000000L;
		char lastOp = ' ';
		for (int i = 0; i < n; i++) {
			char op = (char)((int)(Math.random()*3)+65);
			if(lastOp=='C' || op!='C') {
				//int numOp = (int)(Math.random()*Math.min(n-i-1,opRep))+1;
				//for (int j = 0; j < numOp; j++) {
				op = (char)((int)(Math.random()*2)+65);
					if(op=='A') {
						lastLeft -= (long)(Math.random()*interval);
						bw.write(op+" "+lastLeft+"\n");
					}else {
						lastRight += (long)(Math.random()*interval);
						bw.write(op+" "+lastRight+"\n");						
					}
				//}
				//i += numOp;
			}else {
				bw.write(op+"\n");
			}
			if(i%1000000==0) {
				System.out.println(i);
			}
			
			lastOp = op;

		}
		bw.close();
	}
}
