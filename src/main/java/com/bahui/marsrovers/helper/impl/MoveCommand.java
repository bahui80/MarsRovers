package com.bahui.marsrovers.helper.impl;

import com.bahui.marsrovers.entities.CardinalDirection;
import com.bahui.marsrovers.helper.Command;

public class MoveCommand implements Command {
	private static MoveCommand instance = new MoveCommand();
	
	public static MoveCommand getInstance() {
		return instance;
	}
	
	public CardinalDirection apply(CardinalDirection direction) {
		return direction.move();
	}
}