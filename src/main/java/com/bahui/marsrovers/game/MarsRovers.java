package com.bahui.marsrovers.game;

import com.bahui.marsrovers.entities.CardinalDirection;
import com.bahui.marsrovers.entities.Plateau;
import com.bahui.marsrovers.entities.Rover;
import com.bahui.marsrovers.helper.Point;

public class MarsRovers {
	private Plateau plateau;
	private Point roverPosition;
	private CardinalDirection roverDirection;
	private static final int MIN_NUMBER_OF_ARGS = 6;
	private static final int ROVER_NUMBER_OF_ARGS = 4;
	private static final int PLATEAU_X_ARG_NUMBER = 0;
	private static final int PLATEAU_Y_ARG_NUMBER = 1;
	private static final int PLATEAU_NUMBER_OF_ARGS = 2;
	
	public static void main(String[] args) {
		if(args.length < MIN_NUMBER_OF_ARGS || (args.length % ROVER_NUMBER_OF_ARGS) != PLATEAU_NUMBER_OF_ARGS) {
			throw new IllegalArgumentException("Incorrect number of arguments");
		}
		
		MarsRovers game = new MarsRovers();
		game.run(args);
	}
	
	private void run(String[] args) {
		parsePlateauArgs(args[PLATEAU_X_ARG_NUMBER], args[PLATEAU_Y_ARG_NUMBER]);
		for(int i = PLATEAU_NUMBER_OF_ARGS; i < args.length; i += ROVER_NUMBER_OF_ARGS) {
			parseRoverCoordinates(args[i], args[i + 1], args[i + 2]);
			Rover rover = new Rover(plateau, roverPosition, roverDirection);
			System.out.println(rover.executeCommands(args[i + 3]));
		}
	}
	
	private void parsePlateauArgs(String leftCoordinateStr, String upperCoordinateStr) {
		int leftCoordinate = Integer.valueOf(leftCoordinateStr);
		int upperCoordinate = Integer.valueOf(upperCoordinateStr);
			
		if(leftCoordinate < 0 || upperCoordinate < 0) {
			throw new NumberFormatException("Incorrect values for plateau coordinates. Must be a number greater than 0");
		}
			
		plateau = new Plateau(leftCoordinate, upperCoordinate);
	}
	
	private void parseRoverCoordinates(String xPositionStr, String yPositionStr, String directionStr) {
		int xPosition = Integer.valueOf(xPositionStr);
		int yPosition = Integer.valueOf(yPositionStr);
		
		roverPosition = new Point(xPosition, yPosition);
		
		if(xPosition < 0 || yPosition < 0 || !plateau.containsPosition(roverPosition)) {
			throw new NumberFormatException("Incorrect values for rover position. Must be a number greater than 0 and be within the plateau");
		}
		
		for(CardinalDirection cd: CardinalDirection.values()) {
			if(cd.toString().equals(directionStr)) {
				roverDirection = cd;
				break;
			}
		}
		
		if(roverDirection == null) {
			throw new IllegalArgumentException("Incorrect value for cadrinal point. Must be S,N,W or E");
		}
	}
}