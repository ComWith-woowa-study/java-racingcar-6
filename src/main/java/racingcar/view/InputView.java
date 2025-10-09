package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String[] inputRacingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.split(",");
    }

    public int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        if (tryCount <= 0)
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        return tryCount;
    }
}
