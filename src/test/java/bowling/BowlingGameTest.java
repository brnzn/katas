package bowling;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test(expected = MaxRollesExeededException.class)
    public void expectErrorIfRollingMorethanAllowed() {
        rollMany(22, 0);
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void spareFollowedByNormal() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        game.roll(1);

        rollMany(16, 0);

        assertEquals(17, game.score());
    }

    @Test
    public void strikeFollowedBNormal() {
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(18, 0);
        assertEquals(24, game.score());
    }

    @Test
    public void perfectScore() {
        rollMany(21, 10);
        assertEquals(300, game.score());
    }

    @Test
    public void perfectSpareScore() {
        rollMany(21, 5);
        assertEquals(150, game.score());
    }

    @Test
    public void normalFramesCombinedWithSparesAndStrikes() {
        game.roll(2);
        game.roll(3);
        game.roll(8);
        game.roll(1);
        game.roll(4);
        game.roll(3);
        game.roll(10);
        game.roll(10);
        game.roll(5);
        game.roll(5);
        game.roll(0);
        game.roll(0);
        game.roll(1);
        game.roll(8);
        game.roll(5);
        game.roll(5);
        game.roll(10);
        game.roll(10);
        game.roll(10);

        assertEquals(135, game.score());
    }

    private void rollMany(int n, int pins) {
        IntStream.range(0, n).forEach( i -> {
            game.roll(pins);
        });
    }


}
