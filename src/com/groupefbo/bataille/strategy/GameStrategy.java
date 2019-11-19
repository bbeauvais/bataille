package com.groupefbo.bataille.strategy;

import com.groupefbo.bataille.entity.Carte;

public interface GameStrategy {

	/**
	 * Calcul la puissance de la carte en fonction des règles du jeu. 13 étant la valeur maximum, 1 la valeur minimum.
	 * 
	 * @param carte
	 * @return
	 */
	int strenght(Carte carte);
}
