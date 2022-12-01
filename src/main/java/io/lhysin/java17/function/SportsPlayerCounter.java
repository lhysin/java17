package io.lhysin.java17.function;

import java.util.function.Function;

public enum SportsPlayerCounter {

	FOOT_BALL(cnt -> cnt > 11),

	BASE_BALL(cnt -> cnt > 10);

	private final Function<Integer, Boolean> playerCounter;

	SportsPlayerCounter(Function<Integer, Boolean> playerCounter) {
		this.playerCounter = playerCounter;
	}

	public boolean maximum(Integer currentPlayers) {
		return this.playerCounter
			.apply(currentPlayers);
	}
}