package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Objects;

public class BaseballController {
    private InputView inputView;
    private OutputView outputView;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void init() {
        outputView.start();

        while(true) {
            Computer computer = new Computer();
            computer.setComputer();

        }
    }
}
