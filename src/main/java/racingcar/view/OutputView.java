package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printProgress(Map<String, Integer> position) {
        position.forEach((name, pos) -> {
            String bar = "-".repeat(pos);
            System.out.println(name + " : " + bar);
            System.out.println();
        });
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
