package Gyula.week12.imdb;

public class DBManager {
    private static DBManager instance = null;

    private DBManager(){
       // ...
    }

    public static DBManager getInstance() {
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }
}
