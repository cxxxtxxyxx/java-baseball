package baseball.domain;

import static baseball.domain.Ball.BALL;
import static baseball.domain.Ball.STRIKE;

import java.util.HashMap;

public class Judge {
    ComputerBall computerBall;
    UserBall userBall;
    public Judge(ComputerBall computerBall, UserBall userBall) {
        this.computerBall = computerBall;
        this.userBall = userBall;
    }
    // 힌트를 계산하고 제공하는 객체

    public HashMap<Ball, Integer> getHint() {
        HashMap<Ball, Integer> hint = new HashMap<Ball, Integer>() {{
            put(STRIKE, 0);
            put(BALL, 0);
        }};

        checkBallState(hint);

        return hint;
    }

    private void checkBallState(HashMap<Ball, Integer> hint) {
        for(int i = 0; i < 3; i++) {
            if(isStrike(i)) {
                int prevCount = hint.get(STRIKE);
                hint.put(STRIKE, prevCount + 1);
                continue;
            }
            if(isBall(userBall.getBall(i))){
                int prevCount = hint.get(BALL);
                hint.put(BALL, prevCount + 1);
            }
        }
    }
    private boolean isStrike(int position) {
        return computerBall.getBall(position) == userBall.getBall(position);
    }

    private boolean isBall(int ball) {
        return computerBall.contains(ball);
    }

}
