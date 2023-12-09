package ticTacToe.strategies.gamewinningstrategy;

import ticTacToe.models.Board;
import ticTacToe.models.Cell;
import ticTacToe.models.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Player player, Cell cell);
}
