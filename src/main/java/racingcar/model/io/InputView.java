package racingcar.model.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final int MAX_NAME_LENGTH = 5;

    public List<String> setCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();

        isEmpty(carName);
        List<String> carList = Arrays.stream(carName.split(","))
                .map(String::trim)
                .toList();
        validateNameLength(carList);

        return carList;
    }

    public int setCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();

        isEmpty(count);
        int rounds = Integer.parseInt(count);
        validatePositive(rounds);

        return rounds;
    }

    private void isEmpty(String input) {
        if (input == null || input.isEmpty()){
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private void validateNameLength(List<String> carList) {
        for (String carName : carList) {
            if (carName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름 길이는 " + MAX_NAME_LENGTH + " 이하만 가능합니다.");
            }
        }
    }

    private void validatePositive(int input) {
        if (input <= 0){
            throw new IllegalArgumentException("양의 정수만 입력 가능합니다.");
        }
    }
}
