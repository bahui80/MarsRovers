package com.bahui.marsrovers.helper.impl;

import com.bahui.marsrovers.entities.CardinalDirection;
import com.bahui.marsrovers.helper.Command;

public class TurnRightCommand implements Command {
	private static TurnRightCommand instance = new TurnRightCommand();
	
	public static TurnRightCommand getInstance() {
		return instance;
	}
	
	public CardinalDirection apply(CardinalDirection direction) {
		return direction.turnRight();
	}
}