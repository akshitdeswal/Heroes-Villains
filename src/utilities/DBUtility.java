package utilities;

import models.Hero;
import models.Villain;

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

    public static ArrayList<Villain> getVillainList() throws SQLException {
        ArrayList<Villain> villains = new ArrayList<>();
//        Villain villainOne = new Villain("Thanos", "Gmora", 97, LocalDate.of(2001,9,13), "balancing population", "infinity stones");
//        Villain villainTwo = new Villain("Venom", "Venom", 98, LocalDate.of(2002,8,12), "revenge", "liquid black plasma");
//        villains.add(villainOne);
//        villains.add(villainTwo);
//        return villains;


        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{

            connection = DriverManager.getConnection(connString, user, password);

            statement = connection.createStatement();


            resultSet = statement.executeQuery("SELECT * FROM villains");


            while (resultSet.next()){
                Villain villain = new Villain(resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("strength"),
                        resultSet.getDate("birthday").toLocalDate(),
                        resultSet.getString("evilPurpose"),
                        resultSet.getString("lethalWeapon")
                );
                villains.add(villain);
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
        return villains;
    }

    public static void insertVillianIntoDB(Villain newVillain) throws SQLException {


        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{

            connection = DriverManager.getConnection(connString,user,password);


            statement = connection.prepareStatement("INSERT INTO villains (firstName, lastName, strength, birthday, evilPurpose, lethalWeapon) VALUES " +
                    "(?,?,?,?,?,?)");


            statement.setString(1, newVillain.getFirstName());
            statement.setString(2, newVillain.getLastName());
            statement.setInt(3,newVillain.getStrength());
            statement.setDate(4, Date.valueOf(newVillain.getBirthday()));
            statement.setString(5, newVillain.getEvilPurpose());
            statement.setString(6, newVillain.getLethalWeapon());


            statement.executeUpdate();

        }catch (Exception e)
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
    }
    public static void insertHeroIntoDB(Hero newHero) throws SQLException {


        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{

            connection = DriverManager.getConnection(connString,user,password);


            statement = connection.prepareStatement("INSERT INTO heroes (firstName, lastName, realName, strength, birthday) VALUES " +
                    "(?,?,?,?,?)");


            statement.setString(1, newHero.getFirstName());
            statement.setString(2, newHero.getLastName());
            statement.setString(3, newHero.getRealName());
            statement.setInt(4,newHero.getStrength());
            statement.setDate(5, Date.valueOf(newHero.getBirthday()));


            statement.executeUpdate();

        }catch (Exception e)
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
    }
}
