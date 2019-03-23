package com.magiworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WarriorTest {

    @Test
    public void Given_DammageToEnnemi_WhenBasicAttackIsUsed_Then_RemoveLifeToEnnemi(){
        Guerrier attack = new Guerrier(1,2,2,0,0,10,1);
        Rôdeur defense = new Rôdeur(2,2,1,1,0,10,2);
        attack.attaqueBasique(defense, attack);
        assertTrue(defense.vie == 9);
    }

    @Test
    public void Given_DammageToHimSelf_When_SpecialAttackIsUsed_Then_RemoveLife(){
        Guerrier attack = new Guerrier(1, 2,2,0,0,10,1);
        Guerrier defense = new Guerrier(1, 2, 2, 0, 0, 10, 2);
        attack.attaqueSpecial(defense, attack);
        assertTrue(attack.vie == 9);
    }
}
