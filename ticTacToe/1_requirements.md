Requirement Gathering
================================================================

1. Size of the board can be n x n
2. No. of players = n-1 -> Each player will have its own symbol
3. Player should be able to choose the symbol at the start of the game. No 2 players should have the same symbol
4. We'll have a list of players. Initially we'll randomise the list for player turns
5. Will we have the bot in the system => YES. Only 1 bot per game
6. Bot will have difficulty levels => (EASY / MEDIUM / HARD)
    Ask for below questions
    Timer between the moves ?
    Score / Leaderboard / Tournaments ?
    Pause / Resume / Quit ?
7. Multiple ways of winning the game ? -> Like if 1st player wins, should we stop the game or continue till finding 1st 3 players
    row / column / diagonal
    Is there any blocked cell ?
8. Undo -> Undo the latest move in the game. We can do more than one UNDO operations consecutively