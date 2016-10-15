package bowling;

public class BowlingGame {
    private int[] rolles = new int[21];
    private  int currentRoll = 0;

    public void roll(int pins) {
        if(currentRoll == 21) throw new MaxRollesExeededException();

        rolles[currentRoll++] = pins;
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
        return rolles[roll] == 10;
    }

    private boolean isSpare(int roll) {
        return rolles[roll] + rolles[roll+1] == 10;
    }

    private int normalSum(int frame) {
        return rolles[frame] + rolles[frame + 1];
    }

    private int stikeBonus(int frame) {
        return rolles[frame + 1] + rolles[frame + 2];
    }

    private int spareBonus(int frame) {
        return rolles[frame + 2];
    }
}
