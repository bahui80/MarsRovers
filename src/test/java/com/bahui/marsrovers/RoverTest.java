package com.bahui.marsrovers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bahui.marsrovers.entities.CardinalDirection;
import com.bahui.marsrovers.entities.Plateau;
import com.bahui.marsrovers.entities.Rover;
import com.bahui.marsrovers.helper.Point;

public class RoverTest {
	private Plateau plateau;
	private Point position;
	private CardinalDirection direction;
	private Rover rover;
	
	@Before
	public void setPlateau() {
		plateau = new Plateau(5, 5);
		position = new Point(1,2);
		direction = CardinalDirection.N;
		rover = new Rover(plateau, position, direction);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkRoverPositionOutsidePlateau() {
		new Rover(plateau, new Point(7,7), direction);
	}
	
	@Test
	public void checkCommandsExecution() {
		assertEquals(rover.executeCommands("LMLMLMLMM"), "1 3 N");
	}
	
	@Test
	public void checkIgnoreOutsideMovementNorth() {
		assertEquals(rover.executeCommands("MMMMMMMMMMMMMMM"), "1 5 N");
	}
	
	@Test
	public void checkIgnoreOutsideMovementSouth() {
		assertEquals(rover.executeCommands("LLMMMMMMMMMMMMMMM"), "1 0 S");
	}
	
	@Test
	public void checkIgnoreOutsideMovementWest() {
		assertEquals(rover.executeCommands("LMMMMMMMMMMMMMMM"), "0 2 W");
	}
	
	@Test
	public void checkIgnoreOutsideMovementEast() {
		assertEquals(rover.executeCommands("RMMMMMMMMMMMMMMM"), "5 2 E");
	}
	
	public void checkSamePlace() {
		assertEquals(rover.executeCommands("RRRRMLLLMLLLL"), "1 2 N");
	}
	
}