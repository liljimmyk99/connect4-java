# Connect 4

## Goal
This project is created for students of FRC Team 5401, the Fightin' Robotic Owls.  The project first started out with a formal requirements session where we whiteboarded out all the rules of the game.  From there we turned them into programming contraints & boolean expressions. 

Unlike the original program this is adapted from, we make it object-oriented with 3 classes: Board, Game, and Player.  Since our robot code is OO, it made sense to do a practice problem the same way.

## Extensions Applied
The core of the game was done together as a group & this code contains solutions to 4 challenges I gave the students.

1. Ask the user to play again & reset the game state to the begining
    * (1a) Keep track of how many times Red & Black win & display the results when the user decided to quit
2. Add ```java [] ``` or ```java *```around the 4 pieces that are in a row
3. Ask the user how many rows & columns to use

## Future Refinement
I discussed with the students how the only way a "win" can happen in this game is resulting from a piece that is dropped.  There is **no way** for a player to win without playing a piece.  For example, if Red places a piece Red is the only player that can win at that moment.  Thus the current logic has multiple 2D for-loops resulting in O(n(n^2)) runtime.  A refinement would be to check the 4 winning scenarios (Horizontal, Vertical, Upwards Diagonal, Downwards Diagonal) without needing a for-loop at all.  

I am giving my students a week to figure it out before publishing a solution I have in my head.

## Credit
The core logic of this project was adapted from [https://gist.github.com/jonathan-irvin/97537512eb65a8bbcb9a](https://gist.github.com/jonathan-irvin/97537512eb65a8bbcb9a).