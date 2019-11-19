package com.groupefbo.bataille;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import com.groupefbo.bataille.entity.Carte;
import com.groupefbo.bataille.entity.Joueur;
import com.groupefbo.bataille.strategy.GameStrategy;

public class Bataille {

	private final List<Joueur> joueurs = new LinkedList<>();
	private final Map<Joueur, Integer> scores = new HashMap<>();
	private final GameStrategy strategy;

	public Bataille(List<Joueur> joueurs, GameStrategy strategy) {
		this.joueurs.addAll(joueurs);
		this.strategy = strategy;
		this.joueurs.forEach(joueur -> scores.put(joueur, 0));
	}

	public void jouerPartie() {
		int nbTour = 52 / joueurs.size();

		for (int i = 0; i != nbTour; i++) {
			System.out.println("-----------------------");
			System.out.println("Tour " + (i + 1) + " :");

			List<Joueur> tourBestCartePlayers = jouerTour();

			// Si un seul joueur dans les meilleurs, c'est qu'il a remporté le tour
			if (tourBestCartePlayers.size() == 1) {
				Joueur gagnantTour = tourBestCartePlayers.get(0);
				scores.put(gagnantTour, scores.get(gagnantTour) + 1);

				System.out.println(gagnantTour.getName() + " remporte le tour");
			} else {
				System.out.println("Egalité");
			}
		}
	}

	public void printResultat(Consumer<String> affichage) {
		List<Entry<Joueur, Integer>> orderedResult = new LinkedList<>(scores.entrySet());
		orderedResult.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

		StringBuilder text = new StringBuilder("-------------------------").append(System.lineSeparator())
				.append("Les résultats sont : ").append(System.lineSeparator());

		orderedResult.forEach(entry -> text.append(entry.getKey().getName()).append(" score final ")
				.append(entry.getValue()).append(System.lineSeparator()));

		affichage.accept(text.toString());
	}

	private List<Joueur> jouerTour() {
		List<Joueur> roundBestCartePlayer = new LinkedList<>();
		Joueur premierJoueur = joueurs.get(0);
		Carte carteFirstJoueur = premierJoueur.drawCarte();

		printDrawn(premierJoueur, carteFirstJoueur);

		roundBestCartePlayer.add(premierJoueur);
		int bestScore = strategy.strenght(carteFirstJoueur);

		for (int j = 1; j != joueurs.size(); j++) {
			Joueur joueur = joueurs.get(j);
			Carte drawCarte = joueur.drawCarte();

			printDrawn(joueur, drawCarte);

			int carteScore = strategy.strenght(drawCarte);

			if (carteScore == bestScore) {
				roundBestCartePlayer.add(joueur);
			}

			if (carteScore > bestScore) {
				roundBestCartePlayer.clear();
				roundBestCartePlayer.add(joueur);
				bestScore = carteScore;
			}
		}

		return roundBestCartePlayer;
	}

	private void printDrawn(Joueur joueur, Carte carte) {
		System.out.println(joueur.getName() + " tire la carte : " + carte.getSymbole().getSymbole());
	}
}
