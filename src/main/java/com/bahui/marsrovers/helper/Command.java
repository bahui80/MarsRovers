package com.bahui.marsrovers.helper;

import com.bahui.marsrovers.entities.CardinalDirection;

public interface Command {
	public CardinalDirection apply(CardinalDirection direction);
}