package controller;

import controller.userinput.command.UserInputCommand;
import data.DataBase;
import ui.Message;

public class SystemController {
    private final PlayController playController;
    private final UserInputCommand userInputCommand;
    private final int WIN_POINT = 11;

    public SystemController() {
        this.playController = new PlayController();
        this.userInputCommand = new UserInputCommand();
        Message.WELCOME.print();
        Message.COMPUTER_CREATE.print();
    }

    public void start() {
        boolean retry = true;
        do {
            playController.playBaseball();
            DataBase.getInstance().setStage();
            if (isEndStage()) {
                break;
            }
            retry = userInputCommand.inputCommand();
        } while (retry);
        end();
    }

    private boolean isEndStage() {
        if (DataBase.getInstance().getStage() == WIN_POINT) {
            Message.WIN.print();
            return true;
        }
        return false;
    }

    private void end() {
        System.out.println();
        System.out.println("🏟️ -- 최종 결과 출력 -- 🏟");
        System.out.println("✅ 최종 스테이지 : " + ((DataBase.getInstance().getStage()) - 3) + "Lv");
        System.out.println("✅ 최종 점수 : " + DataBase.getInstance().getScore() + "점");
        Message.GAME_EXIT.print();
    }
}
