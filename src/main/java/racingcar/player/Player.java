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

    // 입력을 한 사용자 인스턴스 반환
    public static Player fromConsole() {
        String inputCars = Console.readLine();
        String inputRounds = Console.readLine();

        List<String> cars = parseCars(inputCars);
        int rounds = parseRounds(inputRounds);

        return new Player(cars, rounds);
    }

    // 입력받을 자동차 이름 검증 로직
    static List<String> parseCars(String inputCars) {
        if (inputCars == null) {
            throw new IllegalArgumentException("차 이름을 입력해주세요!");
        }

        String[] inputCarsArray = inputCars.split(",");
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();


        for (String car : inputCarsArray) {
            String carName = car.trim();
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름에 빈 값은 허용되지 않습니다.");
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }

            if (!set.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }

            list.add(carName);

            if (list.isEmpty()) {
                throw new IllegalArgumentException("자동차는 1대 이상 입력되어야 합니다.");
            }
        }

        return list;
    }

    // 이동 횟수 입력값 검증 로직
    static int parseRounds(String inputRounds) {
        if (inputRounds == null) {
            throw new IllegalArgumentException("이동 횟수를 입력해주세요!");
        }

        try {
            int rounds = Integer.parseInt(inputRounds);
            if (rounds <= 0) {
                throw new IllegalArgumentException("이동 횟수는 양수여야 합니다.");
            }

            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.");
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
