package baseball.view;

public class InputView {
    public static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String INPUT_RESTART_COMMAND = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void inputState() {
        System.out.print(INPUT_NUMBER);
    }

    public static void restart() {
        System.out.println(INPUT_RESTART_COMMAND);

    }
}
