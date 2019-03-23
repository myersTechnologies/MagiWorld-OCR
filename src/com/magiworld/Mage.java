package com.magiworld;

public class Mage extends Attributs{

    String choixPersonnage, cri;

    public Mage(int personnage, int niveau, int force, int agilite, int intelligence, int vie, int player) {
        super(personnage, niveau, force, agilite, intelligence, vie, player);
        this.choixPersonnage = "Mage";
        this.cri = "Abracadabra";
        presentation();
    }

    public void presentation(){
        System.out.println(cri + " je suis le " + choixPersonnage + " je possède " + vie + " de vitalité, " + force + " de force, " + agilite +
                " d'agilité, " + intelligence + " d'intelligence !" );
    }


}
