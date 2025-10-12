package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class InputView {

    public String[] inputRacingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carName = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        validateNonEmpty(carName);
        return carName;
    }

    public int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = Console.readLine();
        validateTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }

    private void validateTryCount(String input) {
        validateNotBlank(input);
        validateIsNumeric(input);

        int tryCount = Integer.parseInt(input);
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어 있거나 공백일 수 없습니다.");
        }
    }

    private void validateNonEmpty(String[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("적어도 하나의 자동차를 입력해야 합니다.");
        }
    }

    private void validateIsNumeric(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다");
        }
    }
}
