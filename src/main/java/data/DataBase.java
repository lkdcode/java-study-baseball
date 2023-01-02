public class DataBase {
    private static final DataBase instance = new DataBase();
    private int stage = 3;
    private int levelUp = 1;


    private DataBase() {
    }

    public static DataBase getInstance() {
        return instance;
    }

    public int getStage() {
        return stage;
    }
}
