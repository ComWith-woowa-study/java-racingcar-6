package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = Console.readLine();
        return Arrays.stream(line.split(","))
                .map(String::trim)
                .peek(name -> { if (name.isEmpty()) throw new IllegalArgumentException("자동차 이름을 입력하세요!"); })
                .toList();
    }

    public int readRounds() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(Console.readLine().trim());
    }
}
