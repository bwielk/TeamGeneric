package generics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	
	private Player baseball;
	private Player football;
	private Player soccer;
	
	@Before
	public void before(){
		baseball = new BaseballPlayer("John");
		football = new FootballPlayer("Mark");
		soccer = new SoccerPlayer("Alex");
	}
	
	@Test
	public void playersHaveName(){
		assertEquals("John", baseball.getName());
		assertEquals("Mark", football.getName());
		assertEquals("Alex", soccer.getName());
	}
}
