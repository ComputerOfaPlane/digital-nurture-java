public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Starting application...");

        Logger logger2 = Logger.getInstance();
        logger2.log("Logging again...");

        if (logger1 == logger2) {
            System.out.println("Only one Logger instance is used (Singleton confirmed).");
        } else {
            System.out.println("Different instances found (Singleton violated).");
        }
    }
}
