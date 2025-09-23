package racingcar.model;

import racingcar.model.car.RacingCar;
import racingcar.model.io.InputView;
import racingcar.model.io.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void gameStart() {
        List<String> carList = inputView.setCarName();
        int round = inputView.setCount();

        List<RacingCar> racingCars = makeRacingCar(carList);
        raceStart(racingCars, round);
    }

    private List<RacingCar> makeRacingCar(List<String> carList) {
        List<RacingCar> racingCar = new ArrayList<>();
        for (String car : carList) {
            racingCar.add(new RacingCar(car));
        }
        return racingCar;
    }

    private void raceStart(List<RacingCar> racingCars, int round) {
        System.out.println("실행 결과");
        for (int i=0; i < round; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.move();
                outputView.printRoundResult(racingCar.getName(), racingCar.getDistance());
            }
            System.out.println();
        }
        outputView.printRaceResult(racingCars);
    }
}
