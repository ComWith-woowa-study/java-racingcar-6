package racingcar;

import racingcar.player.Player;
import racingcar.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars = InputView.readCars();
        int rounds = InputView.readRounds();
        Player player = Player.of(cars, rounds);

        System.out.println("cars = " + player.getCars());
        System.out.println("rounds = " + player.getRounds());

        /*
        cars = [pobi, woni, jun]
        rounds = 5
         */
    }
}
