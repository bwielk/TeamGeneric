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
		assertEquals(true, baseballTeam.addPlayer((BaseballPlayer)baseball));
		assertEquals(true, footballTeam.addPlayer((FootballPlayer)football));
		assertEquals(true, soccerTeam.addPlayer((SoccerPlayer)soccer));
		assertEquals(1, baseballTeam.getMembers().size());
		assertEquals(1, soccerTeam.getMembers().size());
		assertEquals(1, footballTeam.getMembers().size());
	}
	
	@Test
	public void teamCannotAcceptTheSamePlayer(){
		assertEquals(true, baseballTeam.addPlayer((BaseballPlayer)baseball));
		assertEquals(true, footballTeam.addPlayer((FootballPlayer)football));
		assertEquals(true, soccerTeam.addPlayer((SoccerPlayer)soccer));
		assertEquals(false, baseballTeam.addPlayer((BaseballPlayer)baseball));
		assertEquals(1, baseballTeam.getMembers().size());
	}
	
	@Test
	public void teamIsUpdatedIfWinsWithOpponent(){
		footballTeam.matchResult(footballOpponent, 2, 1);
		assertEquals(1, footballTeam.getWins());
		assertEquals(0, footballTeam.getLost());
		assertEquals(0, footballOpponent.getWins());
		assertEquals(1, footballOpponent.getLost());
	}
	
	@Test
	public void footballTeamsCanBeComparedInTermsOfScores(){
		footballTeam.matchResult(footballOpponent, 5, 2);
		assertEquals(1, footballTeam.compareTo(footballOpponent));
		footballTeam.matchResult(footballOpponent, 2, 2);
		assertEquals(1, footballTeam.compareTo(footballOpponent));
		footballTeam.matchResult(footballOpponent, 3, 2);
		assertEquals(1, footballTeam.compareTo(footballOpponent));
		footballTeam.matchResult(footballOpponent, 2, 7);
		assertEquals(1, footballTeam.compareTo(footballOpponent));
		footballTeam.matchResult(footballOpponent, 1, 3);
		assertEquals(0, footballTeam.compareTo(footballOpponent));
	}
	
	@Test
	public void soccerTeamsCanBeComparedInTermsOfScores(){
		soccerTeam.matchResult(soccerOpponent, 4, 9);
		assertEquals(-1, soccerTeam.compareTo(soccerOpponent));
		soccerTeam.matchResult(soccerOpponent, 2, 10);
		assertEquals(-1, soccerTeam.compareTo(soccerOpponent));
		soccerTeam.matchResult(soccerOpponent, 1, 2);
		assertEquals(-1, soccerTeam.compareTo(soccerOpponent));
		soccerTeam.matchResult(soccerOpponent, 3, 2);
		assertEquals(-1, soccerTeam.compareTo(soccerOpponent));
	}
	
	@Test
	public void baseballTeamsCanBeComparedInTermsOfScores(){
		baseballTeam.matchResult(baseballOpponent, 2, 2);
		assertEquals(0, soccerTeam.compareTo(soccerOpponent));
		baseballTeam.matchResult(baseballOpponent, 2, 4);
		assertEquals(0, soccerTeam.compareTo(soccerOpponent));
	}
}