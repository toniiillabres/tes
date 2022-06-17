package JavaTesting.Resources;

public class AppParameters {

    // Lloc ideal per afegit-hi objectes amb connexió de BBDD.

    public static final String DOMAIN = "127.0.0.1";

    public static final String PORT = "80";

    // public static final Object BD_CON = new ClasseConnexioBBDD();

    // public static Object MESSAGE_TRANSLATION;

    // Implementació SINGLETON PATTERN
    private static AppParameters instance;
    // private static final AppParameters instance = new AppParameters();

    private AppParameters(){}

    private void initApp(){}

    private void resetApp(){}

    public static AppParameters getInstance(){
        if (instance == null){
            instance = new AppParameters();
        }

        return instance;
    }

    public static String deployedURL(){
        return "https://"+DOMAIN+":"+PORT;
    }
}
