package com.magiworld;

public class Guerrier extends Attributs {

    String choixPersonnage, cri;

    public Guerrier(int personnage, int niveau, int force, int agilite, int intelligence, int vie, int player) {
        super(personnage, niveau, force, agilite, intelligence, vie, player);
        this.choixPersonnage = "Guerrier";
        this.cri = "Woarg";
        presentation();
    }

    public void presentation(){
        System.out.println(cri + " je suis le " + choixPersonnage + " je possède " + vie + " de vitalité, " + force + " de force, " + agilite +
                " d'agilité, " + intelligence + " d'intelligence !" );
    }


}
