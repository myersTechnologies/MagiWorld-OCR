package com.magiworld;

import java.util.Scanner;

public class Main {

    /**
     * Création des joueurs 1 et 2
     * le joueur 1 commence par attaquer avec la methode choisirAction()
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nb;
        Attributs player1, player2;
        System.out.println("Création du Personnage du Joueur 1");
        player1 = new Attributs(0, 0, 0, 0, 0, 0, 1);
        player1.setPersonnage();
        player1 = new Attributs(player1.personnage, player1.niveau, player1.force, player1.agilite, player1.intelligence, player1.vie, 1);
        System.out.println("Création du Personnage du Joueur 2");
        player2 = new Attributs(0, 0, 0, 0, 0, 0, 2);
        player2.setPersonnage();
        player2 = new Attributs(player2.personnage, player2.niveau, player2.force, player2.agilite, player2.intelligence, player2.vie, 2);
        player1.choisirAction(player1);
        nb = scanner.nextInt();
        player1.setAttack(nb, player1, player2);
    }
}
