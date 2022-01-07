package service;

import lombok.Getter;
import model.Board;
import model.Player;

@Getter
public class GameService {
    private Board board; // can be injected.
    private DiceService diceService;

    public GameService(Board board, DiceService diceService) {
        this.board = board;
        this.diceService = diceService;
    }

    public void startGame() {
        while (true) {
            int currentPlayerIndex = board.getCurrentPlayerIndex();
            Player currentPlayer = board.getPlayers().get(currentPlayerIndex);
            final int move = diceService.getValueOnRoll();
            final int expectedPosition = move + currentPlayer.getLocation();
            System.out.print(String.format("model.Player %s got %s on the dice => Previous Location :- %s ", currentPlayer.getName(), move,
                    currentPlayer.getLocation()));
            updatePlayerLocationOnMove(expectedPosition, board, currentPlayer);
            System.out.println(String.format("New Location :- %s", currentPlayer.getLocation()));
            if(currentPlayer.getLocation() == board.getSize()) {
                System.out.println("===============================================================");
                System.out.println(String.format("PLAYER %s WINS THE GAME", currentPlayer.getName()));
                System.out.println("---- GAME ENDED ----");
                break;
            }
            updateCurrentPlayerIndex(board);
        }
    }

    private void updateCurrentPlayerIndex(final Board board) {
        int currentPlayerIndex = board.getCurrentPlayerIndex();
        int nextPlayerIndex = (currentPlayerIndex + 1) % board.getPlayers().size();
        board.setCurrentPlayerIndex(nextPlayerIndex);
    }

    private void updatePlayerLocationOnMove(int position, final Board board, final Player player) {
       if(board.getSnakes().containsKey(position)) {
            player.setLocation(board.getSnakes().get(position));
            return;
       } else if(board.getLadders().containsKey(position)) {
            player.setLocation(board.getLadders().get(position));
            return;
       } else if (position > board.getSize()) {
           return;
       }
       player.setLocation(position);
    }
}
