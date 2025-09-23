package racingcar.model.io;

import racingcar.model.car.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public void printRoundResult(String carName, int distance) {
        System.out.print(carName + " : ");
        for (int i = 0; distance > i; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printRaceResult(List<RacingCar> racingCars) {
        int max = 0;
        List<String> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getDistance() > max){
                max = racingCar.getDistance();
                winners.clear();
                winners.add(racingCar.getName());
            } else if (racingCar.getDistance() == max) {
                winners.add(racingCar.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
