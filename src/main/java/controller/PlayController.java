package controller.userinput;

import controller.userinput.command.UserInputCommand;
import controller.userinput.number.UserInputNumber;

public class NumberController {
    private UserInputCommand userInputCommand;
    private UserInputNumber userInputNumber;

    public NumberController() {
        this.userInputCommand = new UserInputCommand();
        this.userInputNumber = new UserInputNumber();
    }
}