package Thiemo.week12;

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
