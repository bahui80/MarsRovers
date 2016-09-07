package com.bahui.marsrovers.entities;

import com.bahui.marsrovers.helper.Command;
import com.bahui.marsrovers.helper.Point;
import com.bahui.marsrovers.helper.impl.MoveCommand;
import com.bahui.marsrovers.helper.impl.TurnLeftCommand;
import com.bahui.marsrovers.helper.impl.TurnRightCommand;

public class Rover {
	private Plateau plateau;
	private Point position;
	private CardinalDirection direction;
	
	public Rover(Plateau plateau, Point position, CardinalDirection direction) {
		if(!plateau.containsPosition(position)) {
			throw new IllegalArgumentException("The position of the rover must be inside the plateau");
		}
		this.plateau = plateau;
		this.position = position;
		this.direction = direction;
	}
	
	public String executeCommands(String commands) {
		for (int j = 0; j < commands.length(); j++) {
			Command command = parseCommand(commands.charAt(j));
			if(command == null) {
				System.out.println("Invalid command for rover: " + commands.charAt(j));
			} else {
				executeCommand(command);
			}
		}
		return toString();
	}
	
	private void executeCommand(Command command) {
		CardinalDirection newDirection = command.apply(direction);
		Point newPosition = position.addPoint(newDirection.getPositionMovement());
		
		if(plateau.containsPosition(newPosition)) {
			position = newPosition;
			direction = newDirection;
		}
	}
	
	private Command parseCommand(char command) {
		switch(command) {
			case 'L':
		    	return TurnLeftCommand.getInstance();
		    case 'R':
		    	return TurnRightCommand.getInstance();
		    case 'M':
		    	return MoveCommand.getInstance();
		    default:
		    	return null;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(position);
		builder.append(" ");
		builder.append(direction);
		return builder.toString();
	}
}