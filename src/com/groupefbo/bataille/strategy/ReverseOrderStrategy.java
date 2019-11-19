package com.groupefbo.bataille.strategy;

import com.groupefbo.bataille.entity.Carte;

public class ReverseOrderStrategy implements GameStrategy {

	private final GameStrategy strategy;

	public ReverseOrderStrategy(GameStrategy strategy) {
		super();
		this.strategy = strategy;
	}

	@Override
	public int strenght(Carte carte) {
		return 14 - strategy.strenght(carte);
	}

}
