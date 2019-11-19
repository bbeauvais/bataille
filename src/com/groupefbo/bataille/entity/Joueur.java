package com.groupefbo.bataille.entity;

public class Joueur {

	private final String name;
	private final Paquet hand;
	
	public Joueur(String name, Paquet paquet) {
		this.name = name;
		this.hand = paquet;
	}

	public Carte drawCarte() {
		return hand.drawCarte();
	}

	public String getName() {
		return name;
	}

}
