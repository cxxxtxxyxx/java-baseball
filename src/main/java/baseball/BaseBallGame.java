package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import javax.lang.model.type.ArrayType;


class BaseBallGame {
    private static BaseBallGame gameProgram = new BaseBallGame();

    private BaseBallGame() {
    }

    public static BaseBallGame getGame() {
        return gameProgram;
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void gamePlaying(){
        try {
            int computerNumber = getRandomDiff3DigitNumber();
            boolean isSolved = false;
            while(!isSolved){
                isSolved = solvingProblem(computerNumber);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public boolean solvingProblem(int computerNumber){
        int userNumber = inputNumber();
        int ball, strike;
        System.out.println(computerNumber + "," +  userNumber);
        List<Integer> hint = getHint(userNumber, computerNumber);
        ball = hint.get(0);
        strike = hint.get(1);
        
        if(strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        
        if(ball == 0 && strike == 0){
                System.out.println("낫싱");
        } else {
            if(ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if(strike == 0){
                System.out.println(ball + "볼");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }

        return false;
    }


    private int inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = Console.readLine();
        inputValidation(inputStr);
        return Integer.parseInt(inputStr);
    }

    private void inputValidation(String inputStr) {
        if (!is3DigitNumber(inputStr) || !isDiffDigitNumber(inputStr)) {
            throw new IllegalArgumentException("서로 다른 세자리 수를 입력해주세요.");
        }
    }

    private boolean is3DigitNumber(String inputStr) {
        String inputNumberRegex = "^[1-9]{3}$";
        if (!inputStr.matches(inputNumberRegex)) {
            return false;
        }
        return true;
    }


    private boolean isDiffDigitNumber(String inputStr) {
        if (inputStr.charAt(0) == inputStr.charAt(1) || inputStr.charAt(1) == inputStr.charAt(2)
                || inputStr.charAt(0) == inputStr.charAt(2)) {
            return false;
        }
        return true;
    }

    private int getRandomDiff3DigitNumber() {
        String usedNumber = "";
        String randomDiff3DigitNumber = "";

        while (randomDiff3DigitNumber.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!usedNumber.contains(Integer.toString(randomNumber))) {
                randomDiff3DigitNumber += Integer.toString(randomNumber);
            }
        }

        return Integer.parseInt(randomDiff3DigitNumber);
    }

    private List<Integer> getHint(int userNumber, int computerNumber) {
        List<Integer> userNumList = new ArrayList<>(Arrays.asList(userNumber / 100, userNumber % 100 / 10, userNumber % 10 / 1));
        List<Integer> computerNumList = new ArrayList<>(
                Arrays.asList(computerNumber / 100, computerNumber % 100 / 10, computerNumber % 10 / 1));

        List<Integer> hintList = new ArrayList<Integer>();
        int ball = 0;
        int strike = 0;

        if (userNumList.get(0) == computerNumList.get(0)) {
            strike++;
        } else {
            if (userNumList.get(0) == computerNumList.get(1) || userNumList.get(0) == computerNumList.get(2)) {
                ball++;
            }
        }

        if (userNumList.get(1) == computerNumList.get(1)) {
            strike++;
        } else {
            if (userNumList.get(1) == computerNumList.get(0) || userNumList.get(1) == computerNumList.get(2)) {
                ball++;
            }
        }

        if (userNumList.get(2) == computerNumList.get(2)) {
            strike++;
        } else {
            if (userNumList.get(2) == computerNumList.get(0) || userNumList.get(2) == computerNumList.get(1)) {
                ball++;
            }
        }

        hintList.add(ball);
        hintList.add(strike);

        return hintList;
    }



}
