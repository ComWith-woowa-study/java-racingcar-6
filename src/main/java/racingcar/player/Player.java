package racingcar.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

// 사용자 클래스
public class Player {

    private final List<String> cars;
    private final int rounds;

    public Player(List<String> cars, int rounds) {
        this.cars = Collections.unmodifiableList(new ArrayList<>(cars));
        this.rounds = rounds;
    }

    public static Player of(List<String> cars, int rounds) {
        validateCars(cars);
        validateRounds(rounds);
        return new Player(cars, rounds);
    }

    // 입력받을 자동차 이름 검증 로직
    private static void validateCars(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 1대 이상 입력되어야 합니다.");
        }
        Set<String> set = new HashSet<>();
        for (String carName : cars) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름에 빈 값은 허용되지 않습니다.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            if (!set.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    // 이동 횟수 입력값 검증 로직
    private static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상의 양수여야 합니다.");
        }
    }

    // Getter로 자동차 이름과 시도 횟수를 넘길 수 있도록 함
    public List<String> getCars() {
        return cars;
    }

    public int getRounds() {
        return rounds;
    }
}
