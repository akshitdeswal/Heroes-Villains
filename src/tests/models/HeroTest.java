package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    Hero hero;

    @BeforeEach
    void setUp() {
        ArrayList<String> moves = new ArrayList<>();
        moves.add("stealth moves");
        moves.add("element of surprise");
        hero = new Hero("Akshit", "Deswal", "Akhit Deswal", 90, LocalDate.of(2001, 8, 13), moves) {
            @Override
            int getRank(int strength) {
                return 0;
            }
        };
        hero.setSpecialMoves(moves);
    }


    @Test
    void setRealName() {
        hero.setRealName("Tanu Dhindsa");
        assertEquals("Tanu Dhindsa", hero.getRealName());

    }
}