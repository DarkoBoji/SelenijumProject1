package utils;

public class Utils{

    public  static String generateRandomEmail(){
        return System.currentTimeMillis() + "@email.com";
    }

    public static void waitForSeconds(double seconds) {
        try {
            Thread.sleep((long)(seconds * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
