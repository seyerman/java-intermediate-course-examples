package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		long before = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader("data/fileIn.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/fileOut.txt"));
		
		int n = Integer.parseInt(br.readLine());
		LinkedList ll = new LinkedList();
		//bw.write("ll:"+ll.toString()+"\n");
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			String[] parts = line.split(" ");
			char operation = parts[0].charAt(0);
			long val;
			switch (operation) {
				case 'A':
					val = Long.parseLong(parts[1]);
					ll.addFirst(val);
				break;
				case 'B':
					val = Long.parseLong(parts[1]);
					ll.addLast(val);
				break;
				case 'C':
					val = ll.getMedian();
					bw.write(val+"\n");
				break;
			}
			//bw.write("ll:"+ll.toString()+"\n");
		}
		
		br.close();
		bw.close();
		long after = System.currentTimeMillis();
		System.out.println(after-before);
	}

}
