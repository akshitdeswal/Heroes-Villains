package models;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public abstract class Person {
    private String firstName, lastName;
    private int strength;
    private LocalDate birthday;
    private ArrayList<String> specialMoves;

// constructor with five parameters.
    public Person(String firstName, String lastName, int strength, LocalDate birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        setStrength(strength);
        setBirthday(birthday);

    }
    /*
        rank method
     */
    public int getRank(int strength){
        //get the rank taking strength as marks.
        return 0;
    }
    //setter and getter methods with validations.
    public void setFirstName(String firstName) {
        if (firstName.matches("[A-Z][a-z]*")) {
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("Start the FirstName with capital Letters and Dont Use Numeric Values or characters");
        }
    }

    public void setLastName(String lastName) {
        if (lastName.matches("[A-Z][a-z]*")) {
            this.lastName = lastName;
        }
        else {
            throw new IllegalArgumentException("Start the LastName with capital Letters and Dont Use Numeric Values or characters");
        }
    }

    public void setStrength(int strength) {
        if (strength<=100 && strength>=0) {
            this.strength = strength;
        }
        else{
            throw new IllegalArgumentException("Strength should be marked between 0 & 100"+ strength + " is not valid");
        }
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid birthday, Are U from future!!");
        }
        else{
            this.birthday = birthday;
        }
    }

    public void setSpecialMoves(ArrayList<String> specialMoves) {
        if (specialMoves.size() >= 2) {
            this.specialMoves = specialMoves;
        }
        else{
            throw new IllegalArgumentException("You Must define at least two special moves thats the eligibility criteria");
        }
    }
    /*
    this functions return the current age og the person.
     */
    public int getAge(){
        return Period.between(birthday, LocalDate.now()).getYears();
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStrength() {
        return strength;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public ArrayList<String> getSpecialMoves() {
        return specialMoves;
    }

    public String toString()
    {
        return String.format("%s %s age: %d years, strenght: %d", firstName, lastName, getAge(), strength);
    }
}
