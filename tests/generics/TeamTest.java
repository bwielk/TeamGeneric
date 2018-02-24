package generics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TeamTest {
	
	private Player baseball;
	private Player football;
	private Player soccer;
	private Team team;
	private Team opponent;
	
	@Before
	public void before() {
		team = new Team("Rookiez");
		baseball = new BaseballPlayer("John");
		football = new FootballPlayer("Mark");
		soccer = new SoccerPlayer("Alex");
		opponent = new Team("Opponent");
	}
	
	@Test
	public void teamHasName() {
		assertEquals("Rookiez", team.getName());
		assertEquals("Opponent", opponent.getName());
	}
	
	@Test
	public void teamAcceptsPlayers(){
		assertEquals(true, team.addPlayer(baseball));
		assertEquals(true, team.addPlayer(football));
		assertEquals(true, team.addPlayer(soccer));
		assertEquals(3, team.getMembers().size());
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