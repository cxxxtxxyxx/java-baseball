package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UserBall {
    List<Integer> computerBall;

    public UserBall(String inputBall) {
        checkBallFormat(inputBall);

        this.computerBall = new ArrayList<Integer>();
        String [] balls = inputBall.split("");
        Arrays.stream(balls)
                .forEach(ball -> {
                    computerBall.add(Integer.parseInt(ball));
                });
    }

    private void checkBallFormat(String inputBall) {
        String ballFormatRegex = "^[1-9]{3}$";
        if(!inputBall.matches(ballFormatRegex)) {
            throw new IllegalArgumentException("[ERROR] 올바른 수를 입력해 주세요.");
        }
    }

    private void checkBallDuplication(String[] balls) {
        HashSet<String> validBalls = new HashSet<String>(List.of(balls));
        if(validBalls.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 중복이 되지 않도록 입력해 주세요.");
        }
    }
}
