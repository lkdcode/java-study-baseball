import controller.SystemController;

public class Application {
    private static final SystemController systemController = new SystemController();

    public static void main(String[] args) {
        systemController.start();
    }

}
