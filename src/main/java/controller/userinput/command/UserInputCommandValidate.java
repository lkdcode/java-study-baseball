package controller.userinput.command;

import exception.InputCommandException;

public class UserInputCommandValidate {

    private final String QUIT_COMMAND = "0";
    private final String RETRY_COMMAND = "1";
    private String inputCommand;


    public UserInputCommandValidate() {
        this.inputCommand = new String();
    }

    public boolean userInputCommand(String inputCommand) {
        this.inputCommand = inputCommand;
        return userInputCommandValidate();
    }

    public boolean userInputCommandValidate() {
        try {
            isCommand();
        } catch (InputCommandException error) {
            System.out.println(error);
            return false;
        }

        return true;
    }

    private boolean isCommand() throws InputCommandException {
        if (this.inputCommand.equals(RETRY_COMMAND) || this.inputCommand.equals(QUIT_COMMAND)) {
            return true;
        }
        throw new InputCommandException();
    }
}