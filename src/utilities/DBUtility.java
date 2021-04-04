package utilities;

public class DBUtility {
    public static boolean existingName(String actorName){
        return actorName.matches("[A-Z][a-z]*");
    }
}
