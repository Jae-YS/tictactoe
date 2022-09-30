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
        while(true){
            String input = sc.nextLine().toUpperCase();
            if(input.equals("Q")) return null;
            input = input.replace(" ", "");
            int row = input.charAt(0) - 65;
            int col = input.charAt(1) - 49; 
            nextMove =  new Move(row, col);
            boolean valid = game.isValidMove(nextMove);

            if(valid && row < 3 && col < 3 && row > -1 && col > -1) break;

            System.out.println("Invalid input, try again!\nEnter a move: A-C, 1-3 or 'q' to quit");
    
        }
        return nextMove;
    }
}