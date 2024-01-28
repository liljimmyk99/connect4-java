package Game;

public class Board {
    private int rows;
    private int columns;
    private char[][] values;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        values = new char[rows][columns];
        this.newGame();
    }

    public void newGame() {
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns; col++) {
                values[row][col] = ' ';
            }
        }
    }

    public void display(){
        System.out.println("  0   1   2   3   4   5   6 ");
        System.out.println(" ---------------------------");
        for (int row = 0; row < this.rows; row++) {
            System.out.print("|");
            for (char value : this.values[row]) {
                System.out.print(" " + value + " |");
            }
            System.out.println();
            System.out.println(" ---------------------------");

        }
        System.out.println("  0   1   2   3   4   5   6 ");
        System.out.println();
    }

    public void makeMove(int column, char currentPlayer){
        for(int row = this.values.length - 1; row >= 0; row--){
            if (this.values[row][column] == ' '){
            values[row][column] = currentPlayer;
            break;
            }
        }
    }

    public boolean validateMove(int column) {
        if (column >= this.columns || column < 0) {
            return false;
        }

        if (this.values[0][column] != ' ') {
            return false;
        }

        return true;
    }

    public boolean isWinner(char player) {
        // Check for 4 across
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns - 3; col++) {
                if (
                    this.values[row][col] == player && 
                    this.values[row][col + 1] == player &&
                    this.values[row][col + 2] == player && 
                    this.values[row][col + 3] == player) {
                    this.displayHorizontalWinner(row, col);
                        return true;
                }
            }
        }

        // Check for 4 up and down
        for (int row = 0; row < this.rows - 3; row++) {
            for (int col = 0; col < this.columns; col++) {
                if (
                    this.values[row][col] == player && 
                    this.values[row +1][col] == player &&
                    this.values[row + 2][col] == player && 
                    this.values[row + 3][col] == player) {
                    this.displayVerticalWinner(row, col);
                    return true;
                }
            }
        }

        // Check diagonal upwards
        for (int row = 3; row < this.rows; row++) {
            for (int col = 0; col < this.columns - 3; col++) {
                if (
                    this.values[row][col] == player && 
                    this.values[row - 1][col + 1] == player &&
                    this.values[row - 2][col + 2] == player && 
                    this.values[row - 3][col + 3] == player) {
                    this.displayUpwardDiagonalWinner(row, col);
                    return true;
                }
            }
        }

        // Check diagonal downwards
        for (int row = 0; row < this.rows - 3; row++) {
            for (int col = 0; col < this.columns - 3; col++) {
                if (
                    this.values[row][col] == player && 
                    this.values[row + 1][col + 1] == player &&
                    this.values[row + 2][col + 2] == player && 
                    this.values[row + 3][col + 3] == player) {
                    this.displayDownwardDiagonalWinner(row, col);
                    return true;
                }
            }
        }

        return false;
    }

    public void displayHorizontalWinner(int winningRow, int winningColumn){
        System.out.println("  0   1   2   3   4   5   6 ");
        System.out.println(" ---------------------------");
        for (int row = 0; row < this.rows; row++) {
            System.out.print("|");
            for (int column = 0; column < this.columns; column++) {
                if(
                    (column == winningColumn && row == winningRow) ||
                    (column == winningColumn + 1 && row == winningRow) ||
                    (column == winningColumn + 2 && row == winningRow) ||
                    (column == winningColumn + 3 && row == winningRow)
                    ){
                    System.out.print("*" + this.values[row][column] + "*|");
                } else {
                System.out.print(" " + this.values[row][column] + " |");
                }
                
            }

            System.out.println();
            System.out.println(" ---------------------------");
        }
        System.out.println("  0   1   2   3   4   5   6 ");
        System.out.println();
    }
    
    public void displayVerticalWinner(int winningRow, int winningColumn){
        System.out.println("  0   1   2   3   4   5   6 ");
        System.out.println(" ---------------------------");
        for (int row = 0; row < this.rows; row++) {
            System.out.print("|");
            for (int column = 0; column < this.columns; column++) {
                if(
                    (column == winningColumn && row == winningRow) ||
                    (column == winningColumn && row == winningRow + 1) ||
                    (column == winningColumn && row == winningRow + 2) ||
                    (column == winningColumn && row == winningRow + 3)
                    ){
                    System.out.print("*" + this.values[row][column] + "*|");
                } else {
                System.out.print(" " + this.values[row][column] + " |");
                }
                
            }

            System.out.println();
            System.out.println(" ---------------------------");
        }
        System.out.println("  0   1   2   3   4   5   6 ");
        System.out.println();
    }

    public void displayUpwardDiagonalWinner(int winningRow, int winningColumn){
        System.out.println("  0   1   2   3   4   5   6 ");
        System.out.println(" ---------------------------");
        for (int row = 0; row < this.rows; row++) {
            System.out.print("|");
            for (int column = 0; column < this.columns; column++) {
                if(
                    (column == winningColumn && row == winningRow) ||
                    (column == winningColumn + 1 && row == winningRow - 1) ||
                    (column == winningColumn + 2 && row == winningRow - 2) ||
                    (column == winningColumn + 3 && row == winningRow - 3)
                    ){
                    System.out.print("*" + this.values[row][column] + "*|");
                } else {
                System.out.print(" " + this.values[row][column] + " |");
                }
                
            }

            System.out.println();
            System.out.println(" ---------------------------");
        }
        System.out.println("  0   1   2   3   4   5   6 ");
        System.out.println();
    }

    public void displayDownwardDiagonalWinner(int winningRow, int winningColumn){
        System.out.println("  0   1   2   3   4   5   6 ");
        System.out.println(" ---------------------------");
        for (int row = 0; row < this.rows; row++) {
            System.out.print("|");
            for (int column = 0; column < this.columns; column++) {
                if(
                    (column == winningColumn && row == winningRow) ||
                    (column == winningColumn + 1 && row == winningRow + 1) ||
                    (column == winningColumn + 2 && row == winningRow + 2) ||
                    (column == winningColumn + 3 && row == winningRow + 3)
                    ){
                    System.out.print("*" + this.values[row][column] + "*|");
                } else {
                System.out.print(" " + this.values[row][column] + " |");
                }
                
            }

            System.out.println();
            System.out.println(" ---------------------------");
        }
        System.out.println("  0   1   2   3   4   5   6 ");
        System.out.println();
    }

}
