package ui;

import model.SimpleProgressSymbol;
import thread.SimpleProgressSymbolThread;

public class SimpleProgressSymbolUI {
	private SimpleProgressSymbol spb;
	private SimpleProgressSymbolThread spbt;

	public SimpleProgressSymbolUI() {
		spb = new SimpleProgressSymbol();
		spbt = new SimpleProgressSymbolThread(spb, this, 10000);
	}
	
	public void startProgress() {
		spbt.start();
	}

	public void refresh() {
		System.out.print("\r["+spb.getState()+"]");
	}
}
