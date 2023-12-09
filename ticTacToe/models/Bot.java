package ticTacToe.models;

import ticTacToe.factories.BotPlayingStrategyFactory;
import ticTacToe.strategies.botplayingstrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, char symbol, PlayerType type, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, type);
        this.botDifficultyLevel = botDifficultyLevel;
        botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(botDifficultyLevel);
    }
    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }
    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move decideMove(Board board) {
        return botPlayingStrategy.decideMove(this, board);
    }
}
