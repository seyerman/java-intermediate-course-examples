package model;

import java.util.LinkedList;
import java.util.List;

public class Team {
	private List<Player> players;

	public Team() {
		players = new LinkedList<>();
	}
	
	public void addPlayer(int sn, String fn, String pn) {
		Player p = new Player(sn,fn,pn);
		if(players.isEmpty()) {
			players.add(p);
		}else {
			int i = 0;
			while(i<players.size() && p.getShirtNumber() > players.get(i).getShirtNumber()) {
				i++;
			}
			players.add(i,p);
		}
	}
	
	public List<Player> getPlayers(){
		return players;
	}
	
	public String toString() {
		String m;
		m  = "===============\n";
		m += "    PLAYERS\n";
		m += "===============\n";
		for (Player p:players) {
			m += p + "\n";
		}
		return m;
	}
}
