package com.bahui.marsrovers.entities;

import com.bahui.marsrovers.helper.Point;

public class Plateau {
	private Point lowerLeftPosition;
	private Point upperRightPosition;
	
	public Plateau(int upperPosition, int rightPosition) {
		if(upperPosition < 0 || rightPosition < 0) {
			throw new IllegalArgumentException("Plateau upper and right position must be greater than 0");
		}
		lowerLeftPosition = new Point(0, 0);
		upperRightPosition = new Point(upperPosition, rightPosition);
	}
	
	public boolean containsPosition(Point position) {
		return position.checkPointWithin(lowerLeftPosition, upperRightPosition);
	}
}