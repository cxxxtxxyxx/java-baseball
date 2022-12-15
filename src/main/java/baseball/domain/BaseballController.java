package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    public BaseballController() {
    }

    public void init() {
        OutputView.start();

        while(true) {
            ComputerBall computerBall = new ComputerBall();

            InputView.inputState();
            String inputBall = Console.readLine();

            UserBall userBall = new UserBall(inputBall);

        }
    }
}
