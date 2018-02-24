package generics;

import java.util.ArrayList;

public class Team {
	
	private String name;
	private int player = 0;
	private int won = 0;
	private int lost = 0;
	private int tied = 0;
	private ArrayList<Player> mambers = new ArrayList<>();
	
	public Team(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}