package ticTacToe.strategies.gamewinningstrategy;

import ticTacToe.models.Board;
import ticTacToe.models.Cell;
import ticTacToe.models.Player;

public class OrderNWinningStrategy implements GameWinningStrategy {
    @Override
    public boolean checkWinner(Board board, Player player, Cell cell) {
        int dimension = board.getBoard().size();
        char symbol = player.getSymbol();
        int row = cell.getRow();
        int col = cell.getCol();

        boolean checkVertical = true;
        boolean checkHorizontal = true;
        boolean checkMainDiagonal = false;
        boolean checkDiagonal = false;
        if (row == col || row + col == dimension - 1) {
            checkMainDiagonal = true;
            checkDiagonal = true;
        }

        for (int i = 0; i < dimension; i++) {
            Cell verticalCell = checkVertical ? board.getBoard().get(i).get(col) : null;
            Cell horizontalCell = checkHorizontal ? board.getBoard().get(row).get(i) : null;
            Cell mainDiagCell = checkMainDiagonal ? board.getBoard().get(i).get(i) : null;
            Cell diagCell = checkDiagonal ? board.getBoard().get(i).get(dimension - i - 1) : null;
            if(verticalCell != null && verticalCell.getPlayer().getSymbol() != symbol) checkVertical = false;
            if(horizontalCell != null && horizontalCell.getPlayer().getSymbol() != symbol) checkHorizontal = false;
            if(mainDiagCell != null && mainDiagCell.getPlayer().getSymbol() != symbol) checkMainDiagonal = false;
            if(diagCell != null && diagCell.getPlayer().getSymbol() != symbol) checkDiagonal = false;
        }
        return checkVertical || checkHorizontal || checkMainDiagonal || checkDiagonal;
    }
}
