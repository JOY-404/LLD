package ticTacToe.factories;

import ticTacToe.models.BotDifficultyLevel;
import ticTacToe.strategies.botplayingstrategy.BotPlayingStrategy;
import ticTacToe.strategies.botplayingstrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        //if-else conditions will come here.
        return new RandomBotPlayingStrategy();
    }
}