package controller.userinput.number;

import data.DataBase;
import exception.ErrorMessage;
import exception.InputDuplicationException;
import exception.InputLengthException;

import java.util.HashSet;

public class UserInputNumberValidate {

    private int stage = DataBase.getInstance().getStage();
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

    private boolean isDuplication() throws InputDuplicationException {
        HashSet<Character> duplication = new HashSet<>();

        for (int i = 0; i < inputNumber.length(); i++) {
            duplication.add(inputNumber.charAt(i));
        }

        if (duplication.size() != stage) {
            ErrorMessage.USER_INPUT_DUPLICATION.getMessage();
            throw new InputDuplicationException();
        }
        return true;
    }

    private boolean isNumberLength() throws InputLengthException {
        if (inputNumber.length() != stage) {
            throw new InputLengthException(stage);
        }
        return true;
    }

    private boolean isNumber() throws NumberFormatException {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {

            throw new NumberFormatException(ErrorMessage.USER_INPUT_ONLY_NUMBER.getMessage());
        }
        return true;
    }
}