package com.magiworld;

import java.util.Scanner;

public class Attributs {

    int personnage, niveau, force, agilite, intelligence, vie, player, nb;
    Scanner scanner;


    public Attributs(int niveau, int force, int agilite, int intelligence, int vie, int player){
        this.niveau = niveau;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
        vie = niveau * 5;
        this.vie = vie;
        this.player = player;
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
                Attributs guerrier = new Guerrier(niveau, force, agilite, intelligence, vie, player);
                break;
            case 2:
                Attributs rodeur = new Rôdeur(niveau, force, agilite, intelligence, vie, player);
                break;
            case 3 :
                Attributs mage = new Mage(niveau, force, agilite, intelligence, vie, player);
                break;
            case 4:
                break;
        }
    }
}
