package racingcar.domain.car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarRegistrar {
    private final List<RacingCar> carList;

    public CarRegistrar() {
        this.carList = new ArrayList<>();
    }

    public void registerAll(String[] inputCarList) {
        validateDuplicate(inputCarList);

        for (String input : inputCarList) {
            carList.add(RacingCar.from(input));
        }
    }

    public List<RacingCar> getCarList() {
        return List.copyOf(carList);
    }

    private void validateDuplicate(String[] inputCarList) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : inputCarList) {
            if (!uniqueNames.add(name.trim())) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

}
