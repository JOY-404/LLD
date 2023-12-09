// This controller is not required but we are practicing using this controller
package ticTacToe.controller;

import java.util.List;

import ticTacToe.exceptions.InvalidGameBuildException;
import ticTacToe.models.Game;
import ticTacToe.models.GameStatus;
import ticTacToe.models.Player;

public class GameController {
    // All the functionalities required for playing the game
    public void undo() {

    }

    public Game createGame(int dimension, List<Player> players) throws InvalidGameBuildException {
        Game game = Game.getBuilder().setPlayers(players).setDimension(dimension).build();
        return game;
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void executeNextMove(Game game) {
        game.makeNextMove();
    }
    
    public Player getWinner(Game game) {
        return game.getWinner();
    }
}
