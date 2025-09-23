package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar implements Car {

    private final int MIN_VALUE = 0, MAX_VALUE = 9;
    private final int  MOVE_THRESHOLD= 4;
    private final String name;
    private int distance = 0;

    public RacingCar(String carName) {
        this.name = carName;
    }

    @Override
    public void move() {
        int number = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        if (number >= MOVE_THRESHOLD) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

}
