package data;

import java.util.List;

public class Referee {
    private int strike;
    private int ball;

    public Referee() {
    }

    public void playBaseBall(List<Integer> computerNumbers, List<Integer> userNumbers) {
        this.strike = 0;
        this.ball = 0;
        strike(computerNumbers, userNumbers);
        ball(computerNumbers, userNumbers);
    }

    private void strike(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < DataBase.getInstance().getStage(); i++) {
            if (computerNumbers.get(i) == userNumbers.get(i)) {
                this.strike++;
            }
        }
    }

    private void ball(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < DataBase.getInstance().getStage(); i++) {
            if (computerNumbers.contains(userNumbers.get(i))) {
                this.ball++;
            }
        }
        this.ball -= strike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
