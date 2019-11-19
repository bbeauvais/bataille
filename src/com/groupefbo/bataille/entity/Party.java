package com.groupefbo.bataille.entity;

public enum Party {
	TWO(2),
	FOUR(4),
	THIRTEEN(13),
	TWENTY_SIX(26);
	
	private final int nombreJoueur;

	private Party(int nombreJoueur) {
		this.nombreJoueur = nombreJoueur;
	}

	public int getNombreJoueur() {
		return nombreJoueur;
	}
	
}
