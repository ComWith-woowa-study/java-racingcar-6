package racingcar.controller;

import racingcar.domain.car.RacingCar;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    public GameManager(InputView inputView, OutputView outputView, RacingGame racingGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGame = racingGame;
    }

    public void playGame() {
//        List<RacingCar> carList = new ArrayList<>();
//
//        String[] registrationList = InputView.inputRacingCar();
//
//        for (String car : registrationList) {
//            RacingCar racingCar = carRegistrar.registerCar(car);
//            carList.add(racingCar);
//        }
//
//        int tryCount = InputView.inputTryCount();
//
//        System.out.println("\n실행 결과");
//        for (int i = 0; i < tryCount; i++) {
//            for (RacingCar car : carList) {
//                gameEngine.playTurn(car);
//                OutputView.printGameRecord(car);
//            }
//            System.out.println();
//        }
//
//        OutputView.printWinners(referee.judge(carList));
    }

}
