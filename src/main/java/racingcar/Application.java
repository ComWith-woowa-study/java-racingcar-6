package racingcar;

import racingcar.controller.GameManager;
import racingcar.generator.BasicGenerator;
import racingcar.generator.Generator;
import racingcar.policy.BasicMovePolicy;
import racingcar.policy.MovePolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Generator generator = new BasicGenerator();
        MovePolicy movePolicy = new BasicMovePolicy(generator);
        GameManager gameManager = new GameManager(movePolicy, inputView, outputView);
        gameManager.start();
    }
}
