package models;

import java.time.LocalDate;

public class Villain extends Person{

    private String evilPurpose, lethalWeapon;

    public Villain(String firstName, String lastName, int strength, LocalDate birthday, String evilPurpose, String lethalWeapon) {
        super(firstName, lastName, strength, birthday);
        setEvilPurpose(evilPurpose);
        setLethalWeapon(lethalWeapon);
    }

    public void setEvilPurpose(String evilPurpose) {
        if (evilPurpose.length()<30 && evilPurpose.length()>5)
            this.evilPurpose = evilPurpose;
        else
            throw new IllegalArgumentException("Please Be descriptive about purpose, it should contain 5 to 30 characters");
    }

    public void setLethalWeapon(String lethalWeapon) {
        if (lethalWeapon.length()>=2)
        this.lethalWeapon = lethalWeapon;
        else
            throw new IllegalArgumentException("it should contain at least two letters");
    }

    public String getEvilPurpose() {
        return evilPurpose;
    }

    public String getLethalWeapon() {
        return lethalWeapon;
    }


}
