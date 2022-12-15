package baseball.view;

import static baseball.domain.Ball.BALL;
import static baseball.domain.Ball.NOTHING;
import static baseball.domain.Ball.STRIKE;

import baseball.domain.Ball;
import java.util.HashMap;

public class OutputView {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_FINISH = "3개의 숫자를 모두 맞히셨습닌다! 게임 종료";
    public static final int ZERO = 0;
    public static final String BLANK = " ";

    public static void start() {
        System.out.println(OutputView.GAME_START);
    }

    public static void errorState(IllegalArgumentException e) {
        System.out.println(e);
    }

    public static void finish() {
        System.out.println(GAME_FINISH);
    }
    public static void printHint(HashMap<Ball, Integer> hint) {
        int ballCount = hint.get(BALL);
        int strikeCount = hint.get(STRIKE);
        String result = "";
        if(ballCount == ZERO && strikeCount == ZERO) {
            System.out.println(NOTHING.getLabel());
        }

        if(ballCount != ZERO) {
            result += ballCount + BALL.getLabel();
        }

        result += BLANK;

        if(strikeCount != ZERO) {
            result += strikeCount + STRIKE.getLabel();
        }

        System.out.println(result.trim());
    }
}
