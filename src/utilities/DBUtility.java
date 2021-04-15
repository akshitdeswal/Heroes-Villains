package utilities;

import models.Hero;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DBUtility {
    public static boolean existingName(String actorName){
        return actorName.matches("[A-Z][a-z]*");
    }
    private static String user = "root";
    private static String password = "";
    private static String connString = "jdbc:mysql://localhost:3306/HeroesVillains";
    public static ArrayList<Hero> getHeroList() throws SQLException {
        ArrayList<Hero> heroes = new ArrayList<>();
//        Hero heroOne = new Hero("Hulk", "Mode", "Doctor Bruece", 97, LocalDate.of(2001,9,13));
//        Hero heroTwo = new Hero("Captain", "America", "Steve Rogers", 98, LocalDate.of(2002,8,12));
//        heroes.add(heroOne);
//        heroes.add(heroTwo);
//        return heroes;


        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{

            connection = DriverManager.getConnection(connString, user, password);

            statement = connection.createStatement();


            resultSet = statement.executeQuery("SELECT * FROM heroes");


            while (resultSet.next()){
                Hero hero = new Hero(resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("realName"),
                        resultSet.getInt("strength"),
                        resultSet.getDate("birthday").toLocalDate()
                        );
                heroes.add(hero);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            if (connection != null)
                connection.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }
        return heroes;
    }
}
