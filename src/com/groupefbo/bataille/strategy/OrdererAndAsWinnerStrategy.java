package com.groupefbo.bataille.strategy;

import com.groupefbo.bataille.entity.Carte;

public class OrdererAndAsWinnerStrategy implements GameStrategy {

	@Override
	public int strenght(Carte carte) {
		switch (carte.getSymbole()) {
			case TWO : return 1;
			case THREE : return 2;
			case FOUR : return 3;
			case FIVE : return 4;
			case SIX : return 5;
			case SEVEN : return 6;
			case EIGHT : return 7;
			case NINE : return 8;
			case TEN : return 9;
			case VALET : return 10;
			case QUEEN : return 11;
			case KING : return 12;
			case AS : return 13;
			default:
				throw new IllegalStateException("Cas nom géré");
		}
	}

}
