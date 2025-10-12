package racingcar;

import racingcar.controller.GameManager;
import racingcar.domain.car.CarRegistrar;
import racingcar.domain.game.GameEngine;
import racingcar.domain.game.Referee;
import racingcar.domain.game.generator.NumberGenerator;
import racingcar.domain.game.generator.RandomNumberGenerator;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarRegistrar carRegistrar = new CarRegistrar();
        NumberGenerator generator = new RandomNumberGenerator();
        GameEngine gameEngine = new GameEngine(generator);
        Referee referee = new Referee();
        RacingGame racingGame = new RacingGame(carRegistrar, gameEngine, referee);
        GameManager gameManager = new GameManager(inputView, outputView, racingGame);

        gameManager.playGame();
    }
}
