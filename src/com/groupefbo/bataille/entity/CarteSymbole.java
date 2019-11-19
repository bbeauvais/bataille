package com.groupefbo.bataille.entity;

public enum CarteSymbole {
	AS("As"),
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("10"),
	VALET("Valet"),
	QUEEN("Queen"),
	KING("King");
	
	private final String symbole;

	private CarteSymbole(String symbole) {
		this.symbole = symbole;
	}

	public String getSymbole() {
		return symbole;
	}
	
	
}
