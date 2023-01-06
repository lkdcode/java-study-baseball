package controller.userinput.command;

import data.DataBase;
import ui.Message;
import user.UserStatus;
import user.UserStatusHandler;

import java.util.Scanner;

public class UserInputCommand {
    private final String RETRY = "1";
    private final Scanner scanner;
    private final UserInputCommandValidate userInputCommandValidate;

    public UserInputCommand() {
        this.scanner = new Scanner(System.in);
        this.userInputCommandValidate = new UserInputCommandValidate();
    }

    public boolean inputCommand() {
        boolean isValidate;

        do {
            Message.INPUT_COMMAND.print();
            String userInput = scanner.nextLine();

            isValidate = userInputCommandValidate.userInputCommand(userInput);

            if (userInput.equals(RETRY)) {
                UserStatusHandler.getInstance().setUserStatus(UserStatus.PLAY);
                Message.LEVEL_UP.print();
                Message.INPUT_LENGTH.print();
                System.out.println(DataBase.getInstance().getStage());
                return true;
            }

        } while (!isValidate);

        return false;
    }


}
