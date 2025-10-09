package racingcar.domain.factory;

import racingcar.domain.car.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class CarRegistrar {
    private static final int MAX_NAME_LENGTH = 5;
    private final List<RacingCar> carList;

    public CarRegistrar() {
        this.carList = new ArrayList<>();
    }

    public void registerAll(String[] registrationList) {
        for (String car : registrationList) {
            carList.add(register(car));
        }
    }

    public List<RacingCar> getCarList() {
        return List.copyOf(carList);
    }

    private RacingCar register(String carName) {
        String name = carName.trim();

        if (name.isEmpty())
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");

        if (name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");

        return new RacingCar(name);
    }
}
