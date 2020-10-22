package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class MarketList {
	private List<Element> mList;
	private final static String SEPARATOR = ";";
	public final static String SAVE_PATH_FILE = "data/elements.mkl";
	public MarketList() throws ClassNotFoundException, IOException {
		mList = new LinkedList<>();
		loadData();
	}
	public void addElement(String na,double am) {
		Element el = new Element(na,am);
		mList.add(el);
	}
	@Override
	public String toString() {
		String m = "Market List:\n";
		for (int i = 0; i < mList.size(); i++) {
			Element el = mList.get(i);
			m += el.getName()+", "+el.getAmount()+"\n";
		}
		return m;
	}
	public void exportData(String fileName) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		for(Element elem:mList) {
			pw.println(elem.getName()+SEPARATOR+elem.getAmount());
		}
		pw.close();
	}
	public void importData(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while(line!=null) {
			String[] parts = line.split(SEPARATOR);
			String name = parts[0];
			double amount = Double.parseDouble(parts[1]);
			addElement(name,amount);
			line = br.readLine();
		}
		br.close();
	}
	public void saveData() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE));
		oos.writeObject(mList);
		oos.close();
	}
	@SuppressWarnings("unchecked")
	public void loadData() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_PATH_FILE));
		mList = (List<Element>)ois.readObject();
		ois.close();
	}
}
