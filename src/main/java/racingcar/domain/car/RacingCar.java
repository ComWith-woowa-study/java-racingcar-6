package racingcar.domain.car;

public class RacingCar {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int moveCount;

    private RacingCar(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public static RacingCar from(String carName) {
        String name = carName.trim();

        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }

        return new RacingCar(name);
    }

    public void move() {
        moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
