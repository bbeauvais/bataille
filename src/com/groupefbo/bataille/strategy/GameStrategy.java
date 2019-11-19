package com.groupefbo.bataille.strategy;

import com.groupefbo.bataille.entity.Carte;

public interface GameStrategy {

	/**
	 * Calcul la puissance de la carte en fonction des r�gles du jeu. 13 �tant la valeur maximum, 1 la valeur minimum.
	 * 
	 * @param carte
	 * @return
	 */
	int strenght(Carte carte);
}
