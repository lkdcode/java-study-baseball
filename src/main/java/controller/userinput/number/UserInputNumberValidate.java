package controller.userinput.number;

import data.DataBase;
import exception.ErrorMessage;
import exception.InputDuplicationException;
import exception.InputLengthException;

import java.util.Arrays;
import java.util.HashSet;

public class UserInputNumberValidate {

    private String inputNumber;


    public boolean userInputNumbers(String inputNumber) {
        this.inputNumber = inputNumber;
        return userInputValidate();
    }

    public boolean userInputValidate() {

        try {
            isNumberLength();
            isDuplication();
            isNumber();
        } catch (Exception error) {
            System.out.println(error);
            return false;
        }

        return true;
    }

    /**
     * @return
     * @throws InputDuplicationException
     */
    private boolean isDuplication() throws InputDuplicationException {
        HashSet<String> duplication = new HashSet<>(Arrays.asList(inputNumber.split("")));

        if (duplication.size() != DataBase.getInstance().getStage()) {
            ErrorMessage.USER_INPUT_DUPLICATION.getMessage();
            throw new InputDuplicationException();
        }

        return true;
    }

    /**
     * @return
     * @throws InputLengthException
     */
    private boolean isNumberLength() throws InputLengthException {
        if (inputNumber.length() != DataBase.getInstance().getStage()) {
            throw new InputLengthException(DataBase.getInstance().getStage());
        }
        return true;
    }

    /**
     * @return
     * @throws NumberFormatException
     */
    private boolean isNumber() throws NumberFormatException {
        try {
            Long.parseLong(inputNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.USER_INPUT_ONLY_NUMBER.getMessage());
        }
        return true;
    }
}