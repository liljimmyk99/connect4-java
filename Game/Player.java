package Game;

import java.util.Scanner;

public class Player {
    private Scanner input = new Scanner(System.in);
    public char currentPlayer = 'R';

    public Player(char player){
        this.currentPlayer = player;
    }

    public int getMove(){
        System.out.println("Player: " + this.currentPlayer + ", choose a column");
        return input.nextInt();
    } 

    public void nextPerson(){
        if(this.currentPlayer == 'R'){
            this.currentPlayer = 'B';
        } else {
            this.currentPlayer = 'R';
        }
    }

    public boolean askPlayAgainGame(){
        boolean validInput = false;

        while (!validInput){
            int choice = this.getIntWithPrompt("Do you want to play again? 1 for Yes/0 for N");
            System.out.println(choice);

            if(choice == 1){
                return true;
            } else if (choice == 0){
                return false;
            }
        }
        return false;
    }
    
    public int getIntWithPrompt(String prompt){
        System.out.println(prompt);
        return input.nextInt();
    }
}
