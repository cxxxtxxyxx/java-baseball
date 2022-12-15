package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerBall {
    List<Integer> computerBall;

    public ComputerBall() {
        this.computerBall = new ArrayList<Integer>();
        while (computerBall.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBall.contains(randomNumber)) {
                computerBall.add(randomNumber);
            }
        }
    }

    public int getBall(int position) {
        return computerBall.get(position);
    }

    public boolean contains(int ball) {
        return computerBall.contains(ball);
    }

}
