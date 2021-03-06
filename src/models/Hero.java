package models;

import utilities.DBUtility;

import java.time.LocalDate;
import java.util.TreeMap;

public class Hero extends Person{

    private  String realName;
    private TreeMap<String, String> movies;

    public Hero(String firstName, String lastName, String realName, int strength, LocalDate birthday) {
        super(firstName, lastName, strength, birthday);
        setRealName(realName);
        movies = new TreeMap<>();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        if (realName.matches("[A-Z][a-z]* [A-Z][a-z]*")) {
            this.realName = realName;
        }
        else {
            throw new IllegalArgumentException("Start the realName with capital Letters and Dont Use Numeric Values or characters");
        }
    }

    public TreeMap<String, String> getMovies() {
        return movies;
    }

    public void addMovie(String realName, String movie){
        if (!DBUtility.existingName((realName)))
            throw new IllegalArgumentException("actor name not found");
        else{
            movies.put(realName, movie);
        }
    }
    public String getMovieFromActorName(String realName){
        if (movies.get(realName) == null){
            return "Default";
        }
        return movies.get(realName);
    }



}
