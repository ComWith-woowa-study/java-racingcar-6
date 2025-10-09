package racingcar.service;

import racingcar.domain.factory.CarRegistrar;
import racingcar.domain.game.GameEngine;
import racingcar.domain.game.Referee;

public class RacingGame {
    private final CarRegistrar carRegistrar;
    private final GameEngine gameEngine;
    private final Referee referee;

    public RacingGame(CarRegistrar carRegistrar, GameEngine gameEngine, Referee referee) {
        this.carRegistrar = carRegistrar;
        this.gameEngine = gameEngine;
        this.referee = referee;
    }

}
