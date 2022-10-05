import java.util.Scanner;

public class HumanPlayer extends APlayer{
 
    HumanPlayer(Game game, char symbol){
        super(game,symbol);
    }

    public Move pickMove(){
        Scanner sc = new Scanner(System.in);
        if(this.symbol == 'O') System.out.println("Player 1 enter your move: A-C, 1-3 or 'Q' to quit");
        else System.out.println("Player 2 enter your move: A-C, 1-3 or 'Q' to quit");
        Move nextMove; 
        boolean valid;
        int row;
        int col;

        do{
            String input = sc.nextLine().toUpperCase();
            if(input.equalsIgnoreCase("Q") || input.equalsIgnoreCase("quit")) return null;
            input = input.replace(" ", "");
            if(input.length() != 2) input = "55";

            row = input.charAt(0) - 65;
            col = input.charAt(1) - 49;

            if(row > 2 || col > 2 || row < 0 || col < 0) nextMove = new Move (-1,-1);
            else nextMove =  new Move(row, col);

            valid = game.isValidMove(nextMove);
            System.out.println("Invalid move, try again!\nEnter a move: A-C, 1-3 or 'q' to quit");

        } while(!valid);
        
        return nextMove;
    }
}