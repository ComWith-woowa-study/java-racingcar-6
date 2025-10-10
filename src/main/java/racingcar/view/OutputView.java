package racingcar.view;

import racingcar.domain.car.RacingCar;

import java.util.List;

public class OutputView {

    public void printExecutionResults() {
        System.out.println("\n실행 결과");
    }

    public void printGameRecord(RacingCar car) {
        String printBar = car.getName() + " : " + "-".repeat(car.getMoveCount());
        System.out.println(printBar);
    }

    public void printWinners(List<String> winners) {
        System.out.println("\n최종 우승자 : " + String.join(", ", winners));
    }

    public void printError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
