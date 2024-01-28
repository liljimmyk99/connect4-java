import Game.Game;

/**
 * main
 */
public class main {

    public static void main(String[] args) {
        boolean keepPlaying = true;
        int redWins = 0;
        int blackWins = 0;
        Game connect4 = new Game();

        while(keepPlaying){
            char winningPlayer = connect4.playGame();

            if (winningPlayer == 'R'){
                redWins++;
            } else if (winningPlayer == 'B'){
                blackWins++;
            }
            if(connect4.askPlayAgainGame()){
               connect4.reset();
            } else {
                break;
            }
        }
        System.out.println("Final Score: \n Red: " + redWins + "\n Black: " + blackWins);
    }
}