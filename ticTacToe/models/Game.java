package ticTacToe.models;
import java.util.ArrayList;
import java.util.List;
import ticTacToe.exceptions.InvalidGameBuildException;
import ticTacToe.strategies.gamewinningstrategy.GameWinningStrategy;
import ticTacToe.strategies.gamewinningstrategy.OrderOneWinningStrategy;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private GameWinningStrategy gameWinningStrategy;
    private Player winner;

    public Player getWinner() {
        return winner;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }
    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }
    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void displayBoard() {
        this.board.display();
    }

    public void makeNextMove() {
        Player playerToMove = players.get(nextPlayerIndex);
        System.out.println("It is " + playerToMove.getName() + "'s turn to play");
        Move move = playerToMove.decideMove(this.board);
        Cell cell = move.getCell();
        int row = cell.getRow();
        int col = cell.getCol();

        System.out.println("Player is making a move at row: " + row + " & col: " + col);
        
        //Game will validate the move. -> TODO.
        cell.setPlayer(playerToMove);
        board.getBoard().get(row).get(col).setPlayer(playerToMove);
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        moves.add(move);

        // Check if WON
        if (gameWinningStrategy.checkWinner(board, playerToMove, cell)) {
            gameStatus = GameStatus.ENDED;
            winner = playerToMove;
        }
        nextPlayerIndex = (nextPlayerIndex+1) % players.size();

        // Winning Strategy.
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;

        public int getDimension() {
            return dimension;
        }
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public List<Player> getPlayers() {
            return players;
        }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        private boolean isValid() {
            if(dimension < 1) {
                return false;
            }
            if (players.size() != dimension - 1) {
                return false;
            }
            return true;
        }
        public Game build() throws InvalidGameBuildException {
            // validate if game building is valid
            if(!isValid()) {
                throw new InvalidGameBuildException("Some wrong input passed");
            }
            Game game = new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setBoard(new Board(dimension));
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setGameWinningStrategy(new OrderOneWinningStrategy(dimension));
            return game;
        }
    }
}
