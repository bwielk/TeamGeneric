package generics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TeamTest {
	
	private Player baseball;
	private Player football;
	private Player soccer;
	private Team team;
	
	@Before
	public void before() {
		team = new Team("Rookiez");
		baseball = new BaseballPlayer("John");
		football = new FootballPlayer("Mark");
		soccer = new SoccerPlayer("Alex");
	}
	
	@Test
	public void teamHasName() {
		assertEquals("Rookiez", team.getName());
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
}
