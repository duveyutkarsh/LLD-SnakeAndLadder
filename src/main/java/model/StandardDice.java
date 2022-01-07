package model;

import java.util.Random;

public class StandardDice implements IDice {
    @Override
    public int roll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
