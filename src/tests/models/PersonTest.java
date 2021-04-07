package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;

    @BeforeEach
    void setUp() {
        ArrayList<String> moves = new ArrayList<>();
        moves.add("stealth moves");
        moves.add("element of surprise");
        person = new Person("Akshit", "Deswal", 90, LocalDate.of(2001, 8, 13), moves) {

        };
        person.setSpecialMoves(moves);
    }


    @Test
    void setFirstName() {
        person.setFirstName("Tanu");
        assertEquals("Tanu",person.getFirstName());
    }

    @Test
    void setFirstNameInvalidNumericEntry(){
        assertThrows(IllegalArgumentException.class, ()->
                person.setFirstName("AKM47"));
    }

    @Test
    void setFirstNameInvalidEmpty(){
        assertThrows(IllegalArgumentException.class, ()->
                person.setFirstName(""));
    }

    @Test
    void setFirstNameInvalidLessLetters(){
        assertThrows(IllegalArgumentException.class, ()->
                person.setFirstName("AD"));
    }

    @Test
    void setLastName() {
        person.setLastName("Dhindsa");
        assertEquals("Dhindsa",person.getLastName());
    }

    @Test
    void setLastNameInvalidNumericEntry(){
        assertThrows(IllegalArgumentException.class, ()->
                person.setLastName("AKM47"));
    }

    @Test
    void setLastNameInvalidEmpty(){
        assertThrows(IllegalArgumentException.class, ()->
                person.setLastName(""));
    }

    @Test
    void setLastNameInvalidLessLetters(){
        assertThrows(IllegalArgumentException.class, ()->
                person.setLastName("AD"));
    }

    @Test
    void setStrength() {
        person.setStrength(95);
        assertEquals(95, person.getStrength());
    }

    @Test
    void setStrengthIvalidLess(){
        assertThrows(IllegalArgumentException.class, ()->
                person.setStrength(-20));

    }

    @Test
    void setStrengthIvalidHigh(){
        assertThrows(IllegalArgumentException.class, ()->
                person.setStrength(120));

    }

    @Test
    void setBirthday() {
        person.setBirthday(LocalDate.of(2001,9,13));
        assertEquals(LocalDate.of(2001,9,13), person.getBirthday());
    }

    @Test
    void setInvalidBirthdayFuture() {
        assertThrows(IllegalArgumentException.class, ()->
                person.setBirthday(LocalDate.of(2050,01,01)));
    }

    @Test
    void setSpecialMoves() {
        ArrayList<String> moves = new ArrayList<>();
        moves.add("stealth move");
        moves.add("element of surprise");
        person.setSpecialMoves(moves);
        assertEquals(moves, person.getSpecialMoves());
    }

    @Test
    void setSpecialMovesInvalid() {
        ArrayList<String> specialPower = new ArrayList<>();
        specialPower.add("stealth move");
        assertThrows(IllegalArgumentException.class, ()->
                person.setSpecialMoves(specialPower));
    }

    @Test
    void getAge() {
        assertEquals(19,person.getAge());
    }

}