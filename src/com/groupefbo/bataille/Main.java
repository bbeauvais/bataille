package com.groupefbo.bataille;

import static java.util.List.of;

import java.util.List;

import com.groupefbo.bataille.entity.Joueur;
import com.groupefbo.bataille.entity.Paquet;
import com.groupefbo.bataille.entity.Party;
import com.groupefbo.bataille.strategy.OrdererAndAsWinnerStrategy;

public class Main {

	public static void main(String[] args) {
		Paquet fullPaquet = new Paquet();
		fullPaquet.initFullGame();
		fullPaquet.shuffle();
		
		List<Paquet> paquetsPourJoueur = fullPaquet.distribute(Party.FOUR);
		Joueur john = new Joueur("John", paquetsPourJoueur.get(0));
		Joueur jane = new Joueur("Jane", paquetsPourJoueur.get(1));
		Joueur michelle = new Joueur("Michelle", paquetsPourJoueur.get(2));
		Joueur michel = new Joueur("Michel", paquetsPourJoueur.get(3));
		
		Bataille game = new Bataille(of(john, jane, michel, michelle), new OrdererAndAsWinnerStrategy());
		game.jouerPartie();
		game.printResultat(System.out::println);
	}
}
