package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VillainTest {
    Villain villain;

    @BeforeEach
    void setUp() {
        ArrayList<String> moves = new ArrayList<>();
        moves.add("strong stone");
        moves.add("soul stones");
        villain= new Villain("Thinos", "Gmaro", 95, LocalDate.of(2002,8,7),moves, "Balancing the population", "Infinitystones");
    }

    @Test
    void setEvilPurpose() {
        villain.setEvilPurpose("Prank with avengers");
        assertEquals("Prank with avengers", villain.getEvilPurpose());
    }

    @Test
    void setEvilPurposeInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
            villain.setEvilPurpose("prak"));

    }

    @Test
    void setLethalWeapon() {
        villain.setLethalWeapon("soul stone");
        assertEquals("soul stone", villain.getLethalWeapon());
    }
    @Test
    void setLethalWeaponInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                villain.setLethalWeapon("a"));
    }
}