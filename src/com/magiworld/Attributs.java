package com.magiworld;

import java.util.Scanner;

public class Attributs {

    int personnage, niveau, force, agilite, intelligence, vie, player, nb;
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
    }

    public void setPersonnage(){
        System.out.println("Veuillez choisir la classe de votre personnage " + "(" + "1 : Guerrier, " + "2 : Rôdeur, " + "3 : Mage)");
        scanner = new Scanner(System.in);
        int nb  = scanner.nextInt();
        personnage = nb;
        setNiveau();
    }

    public void setNiveau(){
        System.out.println("Niveau du personnage ?");
        nb = scanner.nextInt();
        niveau = nb;
        setForce();

    }

    public void setForce(){
        System.out.println("Force du personnage ?");
        nb = scanner.nextInt();
        force = nb;
        setAgilite();
    }

    public void setAgilite(){
        System.out.println("Agilité du personnage ?");
        nb = scanner.nextInt();
        agilite = nb;
        setIntelligence();
    }

    public void setIntelligence(){
        System.out.println("Intelligence du personnage ?");
        nb = scanner.nextInt();
        intelligence = nb;
        infoJoueur(personnage);
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
            case 4:
                break;
        }
    }

    public void choisirAction(){
        if (vie > 0) {
            System.out.println("Joueur " + player + " (" + vie + " Vitalité) veuillez choisir votre action" + "( 1 : Attaque Basique, 2 : Attaque Spécial )");
        }else {
            System.out.println("Jouer " + player + " a perdu");

        }

    }

    public void setAttack(int choice, Attributs attaque, Attributs defense){
        Scanner scanner = new Scanner(System.in);
        changePlayerTurn();
        switch (choice){
            case 1:
                attaque.attaqueBasique(defense);
                break;
            case 2:
                attaque.attaqueSpecial(defense);
                break;
        }
        if (player == 1){
            attaque.choisirAction();
            int nb = scanner.nextInt();
            defense.setAttack(nb, attaque, defense);
        } else if (player == 2){
            defense.choisirAction();
            int nb = scanner.nextInt();
            defense.setAttack(nb, defense, attaque);
        }
    }

    public int getPLayer(){
        return player;
    }

    public void attaqueBasique(Attributs joueur){
        if(personnage == 1){
            System.out.println("Joueur 1 utilise Coup d'Epée et inflige " + joueur.force + " dommages" + "\n" + "Joueur 2 perd " + joueur.force + " points de vie");
            joueur.vie -= joueur.force;
        }
        if(personnage ==2){
            System.out.println("Joueur 1 utilise Tir à l'Arc et inflige " + agilite + " dommages");
            System.out.println("Joueur 2 perd " + agilite  + " points de vie");
            joueur.vie -= agilite;
        }
        if(personnage == 3){
            System.out.println("Joueur 1 utilise Boule de Feu et inflige " + joueur.intelligence + " dommages" + "\n" + "Joueur 2 perd " + joueur.intelligence + " points de vie");
            joueur.vie -= joueur.intelligence;
        }
    }

    public void attaqueSpecial(Attributs joueur){
        if(personnage == 1){
            System.out.println("Joueur 1 utilise Coup de Rage et inflige " + joueur.force * 2 +" dommages" + "\n" + "Joueur 2 perd " + joueur.force * 2 + " points de vie");
            System.out.println("Joueur 1 perd " + force / 2 + " points de vie");
            joueur.vie -= joueur.force * 2;
            vie -= force / 2;
        }
        if (personnage == 2){
            System.out.println("Joueur 1 utilise Concentration et gagne " + niveau / 2 + " en agilité");
            agilite +=  niveau / 2;
        }
        if(personnage == 3){
            if(vie < niveau * 5) {
                vie += intelligence * 2;
                System.out.println("Joueur 1 utilise Soin et gagne " + intelligence * 2 + " en vitalité");
            } else {
                System.out.println("Joueur 1 utilise Soin mais la Vie est au maximum");
            }
        }
    }

    public void changePlayerTurn(){
        if (player == 1){
            player = 2;
        } else if (player == 2){
            player = 1;
        }

    }

}
