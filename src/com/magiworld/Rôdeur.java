package com.magiworld;

public class Rôdeur extends Attributs {

    String choixPersonnage, cri;

    public Rôdeur(int niveau, int force, int agilite, int intelligence, int vie, int player) {
        super(niveau, force, agilite, intelligence, vie, player);
        this.choixPersonnage = "Rôdeur";
        this.cri = "Brwaa";
        presentation();
    }

    public void presentation(){
        System.out.println(cri + " je suis le " + choixPersonnage + " je possède " + vie + " de vitalité, " + force + " de force, " + agilite +
                " d'agilité, " + intelligence + " d'intelligence !" );
    }
}
