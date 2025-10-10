package racingcar.policy;

import racingcar.generator.Generator;

import static racingcar.model.GameConfig.*;

public class BasicMovePolicy implements MovePolicy {

    private final Generator generator;

    public BasicMovePolicy(Generator generator) {
        this.generator = generator;
    }

    @Override
    public boolean move() {
        int randomNumber = generator.generate(MIN_NUMBER, MAX_NUMBER);
        return randomNumber >= PIVOT;
    }
}
