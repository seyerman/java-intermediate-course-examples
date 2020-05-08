package model;

import java.util.ArrayList;
import java.util.List;

public class Ringlete {
	private List<Square> squares;
	private boolean spin;
	
	public Ringlete() {
		squares = new ArrayList<>();
		spin = false;
	}
	
	public void addSquare(double r) {
		Square s = new Square(r);
		squares.add(s);
	}
	
	public void rotateSquares() {
		for (Square s: squares) {
			s.rotate();
		}
	}
	
	public void setSpin(boolean sp) {
		spin = sp;
	}
	
	public boolean getSpin() {
		return spin;
	}
	
	public List<Square> getSquares(){
		return squares;
	}
}
