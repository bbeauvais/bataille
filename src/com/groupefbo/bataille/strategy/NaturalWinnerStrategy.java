package com.groupefbo.bataille.strategy;

import com.groupefbo.bataille.entity.Carte;

public class NaturalWinnerStrategy implements GameStrategy {

	@Override
	public int strenght(Carte carte) {
		switch (carte.getSymbole()) {
			case AS : return 1;
			case TWO : return 2;
			case THREE : return 3;
			case FOUR : return 4;
			case FIVE : return 5;
			case SIX : return 6;
			case SEVEN : return 7;
			case EIGHT : return 8;
			case NINE : return 9;
			case TEN : return 10;
			case VALET : return 11;
			case QUEEN : return 12;
			case KING : return 13;
			default:
				throw new IllegalStateException("Cas nom géré");
		}
	}
}
