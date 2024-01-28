package Game;

public class Game {
    int numTurns = 1;
    boolean isWinner = false;
    Board board;
    Player user;


    public char playGame(){
        user = new Player('R'); 
        int rows = user.getIntWithPrompt("How many rows do you want? Default is 6, must be bigger than 4.");
        int columns = user.getIntWithPrompt("How many columns do you want? Default is 7, must be bigger than 4.");
        board = new Board(rows,columns);

        while(isWinner == false && numTurns <= 42){
            boolean validPlay;
            int play;

            user.nextPerson();
            do {
                board.display();
                
                play = user.getMove();

                validPlay = board.validateMove(play);
            } while(validPlay == false);

            board.makeMove(play, user.currentPlayer);
            isWinner = board.isWinner(user.currentPlayer);

            
            numTurns++;
        }
        
        if (isWinner){
            if(user.currentPlayer == 'R'){
                System.out.println("Red Wins");
                return 'R';
            } else {
                System.out.println("Black Wins");
                return 'B';
            }
        } else {
            System.out.println("Tied Game");
            return ' ';
        }
    }
        
    public void reset(){
        board.newGame();
        isWinner = false;
        numTurns = 1;
    }

    public boolean askPlayAgainGame(){
        return user.askPlayAgainGame();
    }
}
