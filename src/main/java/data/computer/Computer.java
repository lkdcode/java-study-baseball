package controller.userinput.number.computer;

import controller.userinput.number.RandomNumber;
import data.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer implements RandomNumber {
    private final int MAX = 10;
    private final Random random;
    private List<Integer> randomNumbers;
    private int stage;

    public Computer() {
        this.random = new Random();
        this.stage = DataBase.getInstance().getStage();
    }

    @Override
    public void makeNumbers() {
        this.randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != stage) {
            int inputNumber = random.nextInt(MAX);
            if (!randomNumbers.contains(inputNumber)) {
                randomNumbers.add(inputNumber);
            }
        }
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
