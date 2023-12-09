package ticTacToe.strategies.botplayingstrategy;

import ticTacToe.models.Board;
import ticTacToe.models.Bot;
import ticTacToe.models.Move;

public interface BotPlayingStrategy {
    Move decideMove(Bot bot, Board board);
}
