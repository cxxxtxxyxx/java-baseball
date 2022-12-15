package baseball.domain;

import static baseball.domain.Ball.STRIKE;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class BaseballController {
    private static int BALL_SIZE = 3;
    private static String RESTART = "1";

    public BaseballController() {
    }

    public void init() {
        OutputView.start();
        ComputerBall computerBall = new ComputerBall();
        while(true) {
            UserBall userBall = getUserBall();
            Judge judge = new Judge(computerBall, userBall);
            computerBall.nums();
            userBall.nums();
            HashMap<Ball, Integer> hint = judge.getHint();
            OutputView.printHint(hint);
            if(isComplete(hint)) {
                OutputView.finish();
                InputView.restart();
                String command = Console.readLine();
                if(command.equals(RESTART)) {
                    computerBall = new ComputerBall();
                    continue;
                }
                break;
            }
        }
    }
    public boolean isComplete(HashMap<Ball, Integer> hint) {
        return hint.get(STRIKE) == BALL_SIZE;
    }

    public UserBall getUserBall() {
        while(true) {
            try {
                InputView.inputState();
                return new UserBall(Console.readLine());
            } catch (IllegalArgumentException e) {
                OutputView.errorState(e);
            }
        }
    }
}
