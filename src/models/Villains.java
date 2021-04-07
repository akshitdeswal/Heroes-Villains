package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Villains extends Person{

    private String evilPurpose, lethalWeapon;

    public Villains(String firstName, String lastName, int strength, LocalDate birthday, ArrayList<String> specialMoves, String evilPurpose, String lethalWeapon) {
        super(firstName, lastName, strength, birthday, specialMoves);
        setEvilPurpose(evilPurpose);
        setLethalWeapon(lethalWeapon);
    }

    public void setEvilPurpose(String evilPurpose) {
        if (evilPurpose.length()<30 && evilPurpose.length()>0)
            this.evilPurpose = evilPurpose;
        else
            throw new IllegalArgumentException("Please Be descriptive about purpose, it should contain 5 to 30 characters");
    }

    public void setLethalWeapon(String lethalWeapon) {
        if (lethalWeapon.matches("[A-Z][a-z]*") && lethalWeapon.length()>=2)
        this.lethalWeapon = lethalWeapon;
        else
            throw new IllegalArgumentException("please start weapon Name with capital letter and it should contain at least two letters");
    }

    public String getEvilPurpose() {
        return evilPurpose;
    }

    public String getLethalWeapon() {
        return lethalWeapon;
    }


}
