package generics;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
	
	private String name;
	private int won = 0;
	private int lost = 0;
	private int tied = 0;
	private ArrayList<T> members = new ArrayList<>();
	
	public Team(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean addPlayer(Player player){
		if(!members.contains(player)){
			members.add((T) player);
			return true;
		}
		return false;
	}
	
	public ArrayList getMembers(){
		return members;
	}
	
	public int getWins(){
		return won;
	}
	
	public int getLost(){
		return lost;
	}
	
	public void matchResult(Team<T> opponent, int ourScore, int theirScore){
		if(ourScore > theirScore){
			won++;
		}else if(theirScore == ourScore){
			tied++;
		}else{
			lost++;
		}
		if(opponent != null){
			opponent.matchResult(null, theirScore, ourScore);
		}
	}

	private int ranking(){
		return (won*2)+tied;
	}
	public int compareTo(Team<T> team) {
		if(ranking() > team.ranking()){
			return 1;
		}else if(ranking() < team.ranking()){
			return -1;
		}else{
			return 0;
		}
	}
}