package com.groupefbo.bataille.entity;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Paquet {

	private final List<Carte> cartes = new LinkedList<>();

	public void initFullGame() {
		for (int i = 0; i != 4; i++) {
			for (CarteSymbole symbole : CarteSymbole.values()) {
				cartes.add(new Carte(symbole));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cartes);
	}

	public List<Paquet> distribute(Party nbJoueur) {
		List<Paquet> paquets = range(1, nbJoueur.getNombreJoueur() + 1).mapToObj(i -> new Paquet()).collect(toList());

		for (int i = 0; i != 52; i++) {
			paquets.get(i % nbJoueur.getNombreJoueur()).addCarte(cartes.get(i));
		}

		return paquets;
	}

	public void addCarte(Carte carte) {
		cartes.add(carte);
	}

	public Carte drawCarte() {
		if (cartes.isEmpty()) {
			throw new IllegalStateException("Impossible de retirer de carte d'un paquet vide");
		}
		return cartes.remove(0);
	}

}
