package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class BasicGenerator implements Generator {

    @Override
    public int generate(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
