package racingcar.manager;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;
import racingcar.player.Player;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

// 게임 진행자 클래스
public class GameManager {

    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;
    private final int PIVOT = 4;

    private final LinkedHashMap<String, Integer> position = new LinkedHashMap<>();
    private final List<Car> cars = new ArrayList<>();
    private int rounds;

    public void start() {
        List<String> names = InputView.readCars();
        int roundsInput = InputView.readRounds();

        Player player = Player.of(names, roundsInput);
        this.rounds = player.getRounds();

        for (String n : player.getCars()) {
            cars.add(new Car(n));
            position.put(n, 0);
        }

        runRounds();

        List<String> winners = findWinners();
        OutputView.printWinners(winners);
    }

    // 라운드 진행
    private void runRounds() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            progressOnce();
            OutputView.printProgress(position);
            System.out.println();
        }
    }

    // 전진 여부 판단
    public boolean isMoved() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return randomNumber >= PIVOT;
    }

    // 한 번의 이동(모든 차에 대해 전진 여부 판단 및 이동)
    private void progressOnce() {
        for (Car car : cars) {
            if (isMoved()) {
                car.go();
            }
            position.put(car.getName(), car.getPosition());
        }
    }

    // 최종 우승자 출력
    private List<String> findWinners() {
        int max = position.values().stream().mapToInt(i -> i).max().orElse(0);
        List<String> winners = new ArrayList<>();
        position.forEach((car, position) -> {
            if (position == max) {
                winners.add(car);
            }
        });

        return winners;
    }

}
