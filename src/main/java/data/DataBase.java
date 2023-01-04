package data;

public class DataBase {
    private static final DataBase instance = new DataBase();
    private int stage = 3;
//    private int score = 0;

    private DataBase() {
    }

    public static DataBase getInstance() {
        return instance;
    }

    public int getStage() {
        return this.stage;
    }

    public void setStage() {
        this.stage++;
    }
}
