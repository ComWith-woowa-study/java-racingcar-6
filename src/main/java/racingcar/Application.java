package racingcar;

import racingcar.player.Player;

public class Application {
    public static void main(String[] args) {
        Player player = Player.fromConsole();

        System.out.println("cars = " + player.getCars());
        System.out.println("rounds = " + player.getRounds());

        /*
        입력
        pobi,woni,jun
        5
         */

        /*
        출력
        cars = [pobi, woni, jun]
        rounds = 5
         */

    }
}
