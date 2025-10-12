package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class CarRegistrar {
    private final List<RacingCar> carList;

    public CarRegistrar() {
        this.carList = new ArrayList<>();
    }

    public void registerAll(String[] inputCarList) {
        for (String input : inputCarList) {
            carList.add(RacingCar.from(input));
        }
    }

    public List<RacingCar> getCarList() {
        return List.copyOf(carList);
    }

}
