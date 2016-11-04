package tennis

import spock.lang.Specification
import spock.lang.Unroll

class GameSpec extends Specification {
    private Game game

    def setup() {
        game = new Game('player1Name', 'player2Name')
    }

    def "score at start of game should be love all"() {
        when:
            def score = game.getScore()
        then:
            "Love-All" == score
    }

    @Unroll
    def "player1 and player2 scores the same" () {
        given:
            for(int i = 0; i < score; i++) {
                    game.pointFor("player1Name")
                    game.pointFor("player2Name")
            }
        expect:
            expected == game.getScore()
        where:
        score | expected
        1     | 'Fifteen-All'
        2     | 'Thirty-All'
        3     | 'Deuce'
        4     | 'Deuce'
    }

    @Unroll
    def "player1 #p1Score player2 #p2Score" () {
        given:
            for(int i = 0; i < p1Score; i++) {
                game.pointFor("player1Name")
            }
        and:
            for(int i = 0; i < p2Score; i++) {
                game.pointFor("player2Name")
            }
        expect:
            expected == game.getScore()
        where:
        p1Score | p2Score | expected
        1       | 0       | 'Fifteen-Love'
        0       | 1       | 'Love-Fifteen'
        2       | 0       | 'Thirty-Love'
        0       | 2       | 'Love-Thirty'
        3       | 0       | 'Forty-Love'
        0       | 3       | 'Love-Forty'
    }

    @Unroll
    def "Win for #expectedPlayerToWin" () {
        given:
            for(int i=0; i<p1Play; i++)
                game.pointFor("player1Name")
        and:
            for(int i=0; i<p2Play; i++)
                game.pointFor("player2Name")
        expect:
            "Win for $expectedPlayerToWin" == game.getScore()
        where:
            p1Play | p2Play | expectedPlayerToWin
            5      | 3      | 'player1Name'
            3      | 5      | 'player2Name'
            4      | 0      | 'player1Name'
            0      | 4      | 'player2Name'
    }

    @Unroll
    def "Advantage #expectedPlayer" () {
        given:
            for(int i=0; i<p1Score; i++)
                game.pointFor("player1Name")
        and:
            for(int i=0; i<p2Score; i++)
                game.pointFor("player2Name")
        expect:
            "Advantage $expectedPlayer" == game.getScore()
        where:
            p1Score | p2Score | expectedPlayer
            4       | 3       | 'player1Name'
            3       | 4       | 'player2Name'
            5       | 4       | 'player1Name'
            4       | 5       | 'player2Name'

    }
}