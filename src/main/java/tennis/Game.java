package tennis;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Game {

    private String player2Name;
    private String player1Name;

    private int p1Score = 0;
    private int p2Score = 0;

//    private final String scoreTemplate = "%s-%s";

    private final String[] scores = new String[] {"Love", "Fifteen", "Thirty", "Forty"};

    private List<Scorer> scorers;

    Scorer winner = new Scorer(g -> p1Score >= 4 && p1Score - p2Score >= 2 || p2Score >=4 && p2Score -p1Score >= 2 , () -> "Win for " + ((p1Score > p2Score) ? player1Name : player2Name));
    Scorer advantage = new Scorer(g -> (p1Score >=4 || p2Score >=4) && (Math.abs(p1Score - p2Score) == 1) , () -> "Advantage " + ((p1Score > p2Score) ? player1Name : player2Name));
    Scorer equals = new Scorer(g -> (p1Score == p2Score) , () -> (p1Score >= 3) ? "Deuce" : scores[p1Score] + "-All");
    Scorer normal = new Scorer(g -> p1Score != p2Score && p1Score + p2Score <6, () -> String.format("%s-%s", scores[p1Score], scores[p2Score]));

    public Game(String player1, String player2) {
        this.player1Name = player1;
        this.player2Name = player2;

        scorers = Arrays.asList(winner, advantage, equals, normal);
    }

    public String getScore() {
        return scorers.stream().
                filter(s -> s.test(this)).
                findFirst().
                get().
                score();

//        if(winner.test(this)) {
//            return winner.get();
//        }
//
//        if(advantage.test(this))
//            return advantage.get();

//        if(hasWinner()) {
//            return "Win for " + ((p1Score > p2Score) ? player1Name : player2Name);
//        }

//        if(hasAdvantage()) {
//            return "Advantage " + ((p1Score > p2Score) ? player1Name : player2Name);
//        }

//        if(p1Score == p2Score)
//            return equalScore();

//        return String.format(scoreTemplate, scores[p1Score], scores[p2Score]);
    }

    public void pointFor(String player) {
        if(player1Name.equals(player))  {
            p1Score++;
        } else {
            p2Score++;
        }
    }

//    private boolean hasWinner() {
//        return p1Score >= 4 && p1Score - p2Score >= 2 || p2Score >=4 && p2Score -p1Score >= 2;
//    }

//    private boolean hasAdvantage() {
//        return (p1Score >=4 || p2Score >=4) && (Math.abs(p1Score - p2Score) == 1);
//    }
//
//    private String equalScore() {
//        if(p1Score >= 3)
//            return "Deuce";
//        else
//            return scores[p1Score] + "-All";
//    }

    private class Scorer implements Predicate<Game> {
        private final Predicate<Game> predicate;
        private final Supplier<String> supplier;

        Scorer(Predicate<Game> predicate, Supplier<String> supplier) {
            this.predicate = predicate;
            this.supplier =supplier;
        }

        @Override
        public boolean test(Game game) {
            return predicate.test(game);
        }

        String score() {
            return supplier.get();
        }
    }
}

