package generics;

import java.util.ArrayList;

public class Team {
	
	private String name;
	private int player = 0;
	private int won = 0;
	private int lost = 0;
	private int tied = 0;
	private ArrayList<Player> members = new ArrayList<>();
	
	public Team(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean addPlayer(Player player){
		if(!members.contains(player)){
			members.add(player);
			return true;
		}
		return false;
	}
	
	public ArrayList getMembers(){
		return members;
	}
}