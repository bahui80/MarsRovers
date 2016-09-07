package com.bahui.marsrovers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bahui.marsrovers.entities.Plateau;
import com.bahui.marsrovers.helper.Point;

public class PlateauTest {
	private Plateau plateau;
	
	@Before
	public void setPlateau() {
		plateau = new Plateau(5, 5);
	}
	
	@Test
	public void checkPositionInside() {
		assertTrue(plateau.containsPosition(new Point(3,4)));
		assertTrue(plateau.containsPosition(new Point(0,0)));
		assertTrue(plateau.containsPosition(new Point(5,5)));
	}
	
	@Test 
	public void checkPositionOutside() {
		assertFalse(plateau.containsPosition(new Point(-1, 0)));
		assertFalse(plateau.containsPosition(new Point(6, 0)));
		assertFalse(plateau.containsPosition(new Point(6, 9)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkNegativePlateauValues() {
		new Plateau(-5, -1);
	}
}
