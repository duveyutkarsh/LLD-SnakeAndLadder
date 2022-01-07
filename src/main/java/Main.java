import model.Board;
import model.Player;
import model.PropType;
import model.StandardDice;
import service.DiceService;
import service.GameService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> snakes = new HashMap<>();
        HashMap<Integer, Integer> ladders = new HashMap<>();
        putPropsIfValid(snakes, PropType.SNAKE, 15, 11, 19, 12);
        putPropsIfValid(ladders, PropType.LADDER, 2, 17, 5, 16);

        List<Player> players = new ArrayList<>();
        addPlayers(players);

        DiceService diceService = new DiceService(new StandardDice());

        final Board board = Board.getInstance(100, snakes, ladders, players);
        final GameService gameService = new GameService(board, diceService);
        gameService.startGame();
    }

    private static void putPropsIfValid(final HashMap<Integer, Integer> map, PropType propType, int... inputs) throws Exception {
        int n = inputs.length;
        if(n % 2 != 0) {
            throw new Exception("input length should be even");
        }
        for(int i = 0; i < n; i = i + 2) {
            int from = inputs[i];
            int to = inputs[i + 1];
            if(to >= from && propType == PropType.SNAKE) {
                map.clear();
                throw new Exception("to should be less than from for Snakes");
            } else if(to <= from && propType == PropType.LADDER) {
                map.clear();
                throw new Exception("to should be greater than from for Ladders");
            }
            map.put(from, to);
        }
    }

    private static void addPlayers(final List<Player> players) {
        players.add(new Player("a"));
        players.add(new Player("b"));
        players.add(new Player("c"));
        players.add(new Player("d"));
        players.add(new Player("e"));
        players.add(new Player("f"));
        players.add(new Player("g"));
    }
}
