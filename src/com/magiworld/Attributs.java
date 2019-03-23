package com.magiworld;

import org.w3c.dom.Attr;

import java.util.Scanner;

public class Attributs {

    int personnage, niveau, force, agilite, intelligence, vie, player, nb, turn;
    Scanner scanner;
    Attributs playerPersonnage;


    public Attributs(int personnage, int niveau, int force, int agilite, int intelligence, int vie, int player){
        this.niveau = niveau;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
        vie = niveau * 5;
        this.vie = vie;
        this.player = player;
        this.personnage = personnage;
        turn = 1;
    }

    public void setPersonnage(){
        System.out.println("Veuillez choisir la classe de votre personnage " + "(" + "1 : Guerrier, " + "2 : Rôdeur, " + "3 : Mage)");
        scanner = new Scanner(System.in);
        int nb  = scanner.nextInt();
        if (nb >= 1 && nb <= 3) {
            personnage = nb;
            setNiveau();
        } else {
            System.out.println("Veuillez cjoisir parmis les classes de personnages proposées!");
            setPersonnage();
        }
    }

    public void setNiveau(){
        System.out.println("Niveau du personnage ?");
        nb = scanner.nextInt();
        if(nb >= 1 && nb <= 100){
            niveau = nb;
            setForce();
        } else {
            System.out.println("Veuillez séléctionner un niveau entre 1 et 100");
            setNiveau();
        }
    }

    public void setForce(){
        System.out.println("Force du personnage ?");
        nb = scanner.nextInt();
        if(force <= niveau) {
            if (nb >= 0 && nb <= 100) {
                force = nb;
                setAgilite();
            } else {
                System.out.println("Veuillez choisir la Force de votre personnage entre 0 et 100");
                setForce();
            }
        } else {
            System.out.println("La Force ne doit pas dépasser le Niveau");
        }
    }

    public void setAgilite(){
        System.out.println("Agilité du personnage ?");
        nb = scanner.nextInt();
        if (force + nb <= niveau){
            if(nb >= 0 && nb <= 100) {
                agilite = nb;
                setIntelligence();
            } else {
                System.out.println("Veuillez choisir l'Agilité de votre personnage entre 0 et 100");
                setAgilite();
            }
        } else {
            System.out.println("La combinaison de Force et Agilité ne doit pas dépasser le Niveau");
            setAgilite();
        }
    }

    public void setIntelligence(){
        System.out.println("Intelligence du personnage ?");
        nb = scanner.nextInt();
        if (force + agilite + nb <= niveau) {
            if (nb >= 0 && nb <= 100) {
                intelligence = nb;
                infoJoueur(personnage);
            } else {
                System.out.println("Veuillez choisir l'Intéligence de votre personnage entre 0 et 100");
                setIntelligence();
            }
        } else {
            System.out.println("La combinaison de Force, Agilité et Intelligence ne doit pas dépasser le Niveau");
            setIntelligence();
        }
    }

    public void infoJoueur(int personnage){
        switch (personnage){
            case 1:
                playerPersonnage = new Guerrier(this.personnage, niveau, force, agilite, intelligence, vie, player);
                break;
            case 2:
                playerPersonnage = new Rôdeur(this.personnage, niveau, force, agilite, intelligence, vie, player);
                break;
            case 3 :
                playerPersonnage = new Mage(this.personnage, niveau, force, agilite, intelligence, vie, player);
                break;
        }
    }

    public void choisirAction(Attributs joueur){
        if (vie > 0) {
            System.out.println("Joueur " + joueur.player + " (" + vie + " Vitalité) veuillez choisir votre action" + "( 1 : Attaque Basique, 2 : Attaque Spécial )");
        }else {
            System.out.println("Jouer " + joueur.player + " a perdu");
        }
    }

    public void setAttack(int choice, Attributs attaque, Attributs defense){
        Scanner scanner = new Scanner(System.in);
        switch (choice){
            case 1:
                attaque.attaqueBasique(defense, attaque);
                break;
            case 2:
                attaque.attaqueSpecial(defense, attaque);
                break;
        }
        changePlayerTurn();
        if (turn == 1){
            attaque.choisirAction(attaque);
            int nb = scanner.nextInt();
            defense.setAttack(nb, attaque, defense);
        } else if (turn == 2){
            defense.choisirAction(defense);
            int nb = scanner.nextInt();
            defense.setAttack(nb, defense, attaque);
        }
    }

    public int getPLayer(){
        return player;
    }

    public void attaqueBasique(Attributs joueur, Attributs attaque){
        if(personnage == 1){
            System.out.println("Joueur " + attaque.player + " utilise Coup d'Epée et inflige " + joueur.force + " dommages" + "\n" + "Joueur " + joueur.player + " perd " + joueur.force + " points de vie");
            joueur.vie -= joueur.force;
        }
        if(personnage ==2){
            System.out.println("Joueur " + attaque.player + " utilise Tir à l'Arc et inflige " + attaque.agilite + " dommages");
            System.out.println("Joueur " + joueur.player +" perd " + agilite  + " points de vie");
            joueur.vie -= attaque.agilite;
        }
        if(personnage == 3){
            System.out.println("Joueur " + attaque.player + " utilise Boule de Feu et inflige " + joueur.intelligence + " dommages" + "\n" + "Joueur " + joueur.player + " perd " + joueur.intelligence + " points de vie");
            joueur.vie -= joueur.intelligence;
        }

    }

    public void attaqueSpecial(Attributs joueur, Attributs attaque){
        if(personnage == 1){
            System.out.println("Joueur " + attaque.player + " utilise Coup de Rage et inflige " + joueur.force * 2 +" dommages" + "\n" + "Joueur " + joueur.player + " perd " + joueur.force * 2 + " points de vie");
            System.out.println("Joueur " + attaque.player + " perd " + force / 2 + " points de vie");
            joueur.vie -= joueur.force * 2;
            vie -= force / 2;
        }
        if (personnage == 2){
            System.out.println("Joueur " + attaque.player +" utilise Concentration et gagne " + niveau / 2 + " en agilité");
            agilite +=  niveau / 2;
        }
        if(personnage == 3){
            if(vie < niveau * 5) {
                vie += intelligence * 2;
                System.out.println("Joueur " + attaque.player + " utilise Soin et gagne " + intelligence * 2 + " en vitalité");
            } else {
                System.out.println("Joueur " + attaque.player + " utilise Soin mais la Vie est au maximum");
            }
        }
    }

    public void changePlayerTurn(){
        if (turn == 2){
            turn = 1;
        }
        if (turn == 1){
            turn = 2;
        }
    }
}
