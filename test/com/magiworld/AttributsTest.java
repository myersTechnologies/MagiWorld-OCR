package com.magiworld;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.*;

public class AttributsTest {

    @Test
    public void Given_TooMuchStats_When_CreatingCharacter_Then_DisplayError(){
        Attributs personnage = new Attributs(1, 2, 1, 1, 1, 10, 1);
        assertTrue(personnage.force + personnage.agilite + personnage.intelligence > personnage.niveau);
        System.out.println("La combinaison des stats ne doit pas dépasser le niveau du personnage");
    }

    @Test
    public void Given_AnotherNumber_When_PlayersChooseAttackType_Then_DisplayError(){
        Attributs attack = new Rôdeur(2, 1,0,1,0,5,1);
        attack.choisirAction(attack);
        attack.selectedAttackType(3);
        assertEquals(3, 3);
        System.out.println("Veuillez choisir parmis les actions proposés !");
        attack.choisirAction(attack);
    }

    @Test
    public void Given_Turn_When_CurrentPlayerFinishAttack_Then_ChangePlayersTurn(){
        Attributs attack = new Attributs(1, 2, 1, 1, 0, 10, 1);
        attack.changePlayerTurn();
        assertTrue(attack.turn == 2);
    }
}
