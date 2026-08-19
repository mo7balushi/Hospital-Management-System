package utils;

public class HelperUtils {

    private static int idCounter = 1;


    // Generate ID without prefix
    public static String generateId() {

        String id = String.valueOf(idCounter);
        idCounter++;

        return id;
    }


    // Generate ID with prefix
    public static String generateId(String prefix) {

        String id = prefix + idCounter;
        idCounter++;

        return id;
    }
}
