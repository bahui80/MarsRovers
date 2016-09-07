package com.bahui.marsrovers;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bahui.marsrovers.entities.CardinalDirection;
import com.bahui.marsrovers.helper.Point;


public class CardinalDirectionTest {
	
	@Test
	public void testNorthDirection() {
		CardinalDirection direction = CardinalDirection.N;
		
		// On left turn, direction must be W and positionMovement = (0,0)
		CardinalDirection result = direction.turnLeft();
		assertEquals(result, CardinalDirection.W);
		assertEquals(result.getPositionMovement(), new Point(0,0));
		
		// On right turn, direction must be E and positionMovement = (0,0)
		result = direction.turnRight();
		assertEquals(result, CardinalDirection.E);
		assertEquals(result.getPositionMovement(), new Point(0,0));
		
		// On move turn, direction must be N and positionMovement = (0,1)
		result = direction.move();
		assertEquals(result, CardinalDirection.N);
		assertEquals(result.getPositionMovement(), new Point(0,1));
	}
	
	@Test
	public void testSouthDirection() {
		CardinalDirection direction = CardinalDirection.S;
		
		// On left turn, direction must be E and positionMovement = (0,0)
		CardinalDirection result = direction.turnLeft();
		assertEquals(result, CardinalDirection.E);
		assertEquals(result.getPositionMovement(), new Point(0,0));
		
		// On right turn, direction must be W and positionMovement = (0,0)
		result = direction.turnRight();
		assertEquals(result, CardinalDirection.W);
		assertEquals(result.getPositionMovement(), new Point(0,0));
		
		// On move turn, direction must be S and positionMovement = (0,-1)
		result = direction.move();
		assertEquals(result, CardinalDirection.S);
		assertEquals(result.getPositionMovement(), new Point(0,-1));
	}
	
	@Test
	public void testEastDirection() {
		CardinalDirection direction = CardinalDirection.E;
		
		// On left turn, direction must be N and positionMovement = (0,0)
		CardinalDirection result = direction.turnLeft();
		assertEquals(result, CardinalDirection.N);
		assertEquals(result.getPositionMovement(), new Point(0,0));
		
		// On right turn, direction must be S and positionMovement = (0,0)
		result = direction.turnRight();
		assertEquals(result, CardinalDirection.S);
		assertEquals(result.getPositionMovement(), new Point(0,0));
		
		// On move turn, direction must be E and positionMovement = (1,0)
		result = direction.move();
		assertEquals(result, CardinalDirection.E);
		assertEquals(result.getPositionMovement(), new Point(1,0));
	}
	
	@Test
	public void testWestDirection() {
		CardinalDirection direction = CardinalDirection.W;
		
		// On left turn, direction must be S and positionMovement = (0,0)
		CardinalDirection result = direction.turnLeft();
		assertEquals(result, CardinalDirection.S);
		assertEquals(result.getPositionMovement(), new Point(0,0));
				
		// On right turn, direction must be N and positionMovement = (0,0)
		result = direction.turnRight();
		assertEquals(result, CardinalDirection.N);
		assertEquals(result.getPositionMovement(), new Point(0,0));
				
		// On move turn, direction must be W and positionMovement = (-1,0)
		result = direction.move();
		assertEquals(result, CardinalDirection.W);
		assertEquals(result.getPositionMovement(), new Point(-1,0));
	}
}
