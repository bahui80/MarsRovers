package com.bahui.marsrovers.helper.impl;

import com.bahui.marsrovers.entities.CardinalDirection;
import com.bahui.marsrovers.helper.Command;

public class TurnLeftCommand implements Command {
	private static final TurnLeftCommand instance = new TurnLeftCommand();
	
	public static TurnLeftCommand getInstance() {
		return instance;
	}
	
	public CardinalDirection apply(CardinalDirection direction) {
		return direction.turnLeft();
	}
}