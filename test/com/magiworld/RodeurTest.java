package com.magiworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RodeurTest {

    @Test
    public void Given_DammageToEnnemi_When_BasicAttackIsUsed_Then_DammageEqualsToEnnemyAgility(){
        Rôdeur attack = new Rôdeur(2,2,0,2,0,10,1);
        Guerrier defense = new Guerrier(1,2,1,1,0,10,2);
        attack.attaqueBasique(defense, attack);
        assertTrue(defense.vie == 8);
    }

    @Test
    public void Given_AgilityToRodeur_When_SpecialAttackIsUsed_Then_AugmenteNiveau(){
        Rôdeur attack = new Rôdeur(2,2,0,2,0,10, 1);
        Guerrier defense = new Guerrier(1, 2, 2,0,0,10,2);
        attack.attaqueSpecial(defense, attack);
        assertTrue(attack.agilite == 3 );
    }
}
