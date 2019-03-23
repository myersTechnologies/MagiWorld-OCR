package com.magiworld;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MageTest {

    @Test
    public void Given_TooMuchLifeToMage_When_SpecialAttackIsUsed_Then_ShowErrorMessage(){
        Mage mage = new Mage(3, 1,0,0,1,5,1);
        Guerrier guerrier = new Guerrier(1,1,1,0,0,5,2);
        mage.attaqueSpecial(guerrier, mage);
        assertTrue(mage.vie + mage.intelligence * 2 > mage.vie);
    }

    @Test
    public void Given_DammagesToEnnemi_When_SimpleAttackIsUsed_Then_EnnemyIntelligencyEqualsToDammage(){
        Mage attack = new Mage(3,1,0,0,1, 5, 1);
        Rôdeur defense = new Rôdeur(2,2,0,0,1,10, 2);
        attack.attaqueBasique(defense, attack);
        assertTrue(defense.vie == 9);
    }
}
