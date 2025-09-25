package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printProgress(Map<String, Integer> position) {
        position.forEach((name, pos) -> {
            String bar = "-".repeat(pos);
            System.out.println(name + " : " + bar);
        });
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
