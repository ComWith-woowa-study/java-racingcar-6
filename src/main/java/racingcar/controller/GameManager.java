package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Player;
import racingcar.policy.MovePolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameManager {

    private final List<Car> cars = new ArrayList<>();
    private int rounds;

    private final MovePolicy movePolicy;
    private final InputView inputView;
    private final OutputView outputView;

    public GameManager(MovePolicy movePolicy, InputView inputView, OutputView outputView) {
        this.movePolicy = movePolicy;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Player player = Player.of(inputView.readCars(), inputView.readRounds());
        this.rounds = player.getRounds();

        for (String n : player.getCars()) {
            cars.add(new Car(n));
        }

        runRounds();
        outputView.printWinners(findWinners());
    }

    private void runRounds() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            progressOnce();
            outputView.printProgress(showStatus());
        }
    }

    // 한 번의 이동(모든 차에 대해 전진 여부 판단 및 이동)
    private void progressOnce() {
        for (Car car : cars) {
            if (movePolicy.move()) {
                car.go();
            }
        }
    }

    // 경주 진행 상태
    private Map<String, Integer> showStatus() {
        Map<String, Integer> status = new LinkedHashMap<>();
        for (Car car : cars) {
            status.put(car.getName(), car.getPosition());
        }

        return status;
    }

    // 최종 우승자 출력
    private List<String> findWinners() {
        int max = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car c : cars) {
            if (c.getPosition() == max) winners.add(c.getName());
        }
        return winners;
    }
}
