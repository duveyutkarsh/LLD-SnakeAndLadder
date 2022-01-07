package model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
public class Board {
    private static Board INSTANCE;

    private Board() {}

    public static Board getInstance() {
        return INSTANCE;
    }

    public static Board getInstance(final int size, final HashMap<Integer, Integer> snakes,
                                    final HashMap<Integer, Integer> ladders,
                                    final List<Player> players) {
        if(INSTANCE == null) {
            INSTANCE = new Board(size, snakes, ladders, players, 0);
        }
        return INSTANCE;
    }

    private int size;
    private HashMap<Integer, Integer> snakes;
    private HashMap<Integer, Integer> ladders;
    private List<Player> players;
    @Setter
    private int currentPlayerIndex;

    private Board(int size, HashMap<Integer, Integer> snakes, HashMap<Integer,
            Integer> ladders, List<Player> players, int currentPlayerIndex) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        this.currentPlayerIndex = currentPlayerIndex;
    }
}
