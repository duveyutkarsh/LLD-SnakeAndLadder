package service;

import model.IDice;

public class DiceService {
    private IDice dice; // Also can be injected using DI framework like google guice.

    public DiceService(IDice dice) {
        this.dice = dice;
    }

    public int getValueOnRoll() {
        return dice.roll();
    }
}
