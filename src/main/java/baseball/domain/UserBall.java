package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserBall {
    List<Integer> computerBall;

    public UserBall(String inputBall) {
        this.computerBall = new ArrayList<Integer>();
        String [] balls = inputBall.split("");
        Arrays.stream(balls)
                .forEach(ball -> {
                    computerBall.add(Integer.parseInt(ball));
                });
    }
}
