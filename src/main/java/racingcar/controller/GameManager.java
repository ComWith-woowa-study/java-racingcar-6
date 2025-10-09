package racingcar.controller;

import racingcar.domain.car.RacingCar;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        racingGame.registerCars(inputView.inputRacingCar());
        int tryCount = inputView.inputTryCount();

        outputView.printExecutionResults();
        for (int i = 0; i < tryCount; i++) {
            playOneRound();
            System.out.println();
        }

        outputView.printWinners(racingGame.judge());
    }

    private void playOneRound() {
        for (RacingCar car : racingGame.getCarList()) {
            racingGame.playRound(car);
            outputView.printGameRecord(car);
        }
    }

}
