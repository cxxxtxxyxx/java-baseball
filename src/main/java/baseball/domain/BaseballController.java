package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class BaseballController {

    public BaseballController() {
    }

    public void init() {
        OutputView.start();

        while(true) {
            ComputerBall computerBall = new ComputerBall();
            UserBall userBall = getUserBall();
            Judge judge = new Judge(computerBall, userBall);
            HashMap<Ball, Integer> hint = judge.getHint();
        }
    }

    public UserBall getUserBall() {
        while(true) {
            try {
                InputView.inputState();
                String inputBall = Console.readLine();
                UserBall userBall = new UserBall(inputBall);
                return userBall;
            } catch (IllegalArgumentException e) {
                OutputView.errorState(e);
            }
        }
    }
}
