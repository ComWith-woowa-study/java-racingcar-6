package racingcar.service;

import racingcar.domain.car.RacingCar;
import racingcar.domain.car.CarRegistrar;
import racingcar.domain.game.GameEngine;
import racingcar.domain.game.Referee;

import java.util.List;

public class RacingGame {
    private final CarRegistrar carRegistrar;
    private final GameEngine gameEngine;
    private final Referee referee;

    public RacingGame(CarRegistrar carRegistrar, GameEngine gameEngine, Referee referee) {
        this.carRegistrar = carRegistrar;
        this.gameEngine = gameEngine;
        this.referee = referee;
    }

    public void playRound(RacingCar car) {
        gameEngine.playTurn(car);
    }

    public List<RacingCar> getCarList() {
        return carRegistrar.getCarList();
    }

    public void registerCars(String[] registrationList) {
        carRegistrar.registerAll(registrationList);
    }

    public List<String> judge() {
        return referee.judge(carRegistrar.getCarList());
    }
}
