package bowling;

public class BowlingGame {
    private int[] rolls = new int[21];
    private  int currentRoll = 0;

    public void roll(int pins) {
        if(currentRoll == 21) throw new MaxRollesExeededException();

        rolls[currentRoll++] = pins;
    }

    int score() {
        int score = 0;
        int currentRoll = 0;
        for(int frame = 0; frame < 10; frame++) {
            if(isStrike(currentRoll)) {
                score += 10 + stikeBonus(currentRoll);
                currentRoll++;
            } else if(isSpare(currentRoll)) {
                score += 10 + spareBonus(currentRoll);
                currentRoll+=2;
            } else {
                score += normalSum(currentRoll);
                currentRoll+=2;
            }
        }
        return score;
    }

    private boolean isStrike(int roll) {
        return rolls[roll] == 10;
    }

    private boolean isSpare(int roll) {
        return rolls[roll] + rolls[roll+1] == 10;
    }

    private int normalSum(int frame) {
        return rolls[frame] + rolls[frame + 1];
    }

    private int stikeBonus(int frame) {
        return rolls[frame + 1] + rolls[frame + 2];
    }

    private int spareBonus(int frame) {
        return rolls[frame + 2];
    }
}
