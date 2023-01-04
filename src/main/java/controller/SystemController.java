package controller;

import controller.userinput.command.UserInputCommand;
import data.DataBase;
import ui.Message;

public class SystemController {
    private final PlayController playController;
    private final UserInputCommand userInputCommand;

    public SystemController() {
        this.playController = new PlayController();
        this.userInputCommand = new UserInputCommand();
        Message.WELCOME.print();
        Message.COMPUTER_CREATE.print();
    }

    public void start() {
        do {
            playController.playBaseball();
            boolean retry = userInputCommand.inputCommand();
            //re
            if (DataBase.getInstance().getStage() > 10) {
                System.out.println("최종 승리!!!!");
                return;
            }
            //

            //re
            if (!retry) {
                break;
            }
            //
        } while (true);
    }
}
