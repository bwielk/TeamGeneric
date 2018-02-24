package generics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TeamTest {
	
	private Player baseball;
	private Player football;
	private Player soccer;
	
	private Team<FootballPlayer> footballTeam;
	private Team<FootballPlayer> footballOpponent;
	
	private Team<BaseballPlayer> baseballTeam;
	private Team<BaseballPlayer> baseballOpponent;
	
	private Team<SoccerPlayer> soccerTeam;
	private Team<SoccerPlayer> soccerOpponent;
	
	@Before
	public void before() {
		footballTeam = new Team<>("Rookiez");
		footballOpponent = new Team<>("Opponent");
		
		baseballTeam = new Team<BaseballPlayer>("Baseballs");
		baseballOpponent = new Team<BaseballPlayer>("BaseDevils");
		
		soccerTeam = new Team<SoccerPlayer>("Suckers");
		soccerOpponent = new Team<SoccerPlayer>("Opps");
		
		baseball = new BaseballPlayer("John");
		football = new FootballPlayer("Mark");
		soccer = new SoccerPlayer("Alex");
	}
	
	@Test
	public void teamHasName() {
		assertEquals("Rookiez", footballTeam.getName());
		assertEquals("Opponent", footballOpponent.getName());
		assertEquals("Baseballs", baseballTeam.getName());
		assertEquals("BaseDevils", baseballOpponent.getName());
		assertEquals("Suckers", soccerTeam.getName());
		assertEquals("Opps", soccerOpponent.getName());
	}
	
	@Test
	public void teamAcceptsPlayers(){
		assertEquals(true, baseballTeam.addPlayer(baseball));
		assertEquals(true, footballTeam.addPlayer(football));
		assertEquals(true, soccerTeam.addPlayer(soccer));
		assertEquals(1, baseballTeam.getMembers().size());
		assertEquals(1, soccerTeam.getMembers().size());
		assertEquals(1, footballTeam.getMembers().size());
	}
	
	@Test
	public void teamCannotAcceptTheSamePlayer(){
		assertEquals(true, team.addPlayer(baseball));
		assertEquals(true, team.addPlayer(football));
		assertEquals(true, team.addPlayer(soccer));
		assertEquals(false, team.addPlayer(baseball));
		assertEquals(3, team.getMembers().size());
	}
	
	@Test
	public void teamIsUpdatedIfWinsWithOpponent(){
		team.matchResult(opponent, 2, 1);
		assertEquals(1, team.getWins());
		assertEquals(0, team.getLost());
		assertEquals(0, opponent.getWins());
		assertEquals(1, opponent.getLost());
	}
}