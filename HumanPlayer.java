import java.util.Scanner;

public class HumanPlayer extends APlayer{

    HumanPlayer(Game game, char symbol){
        super(game,symbol);
    }
    public Move pickMove(){
        return new Move(1,1); 
    }

    /*
    public Move pickMove(){
        System.out.println("Player1 enter your move: A-C, 1-3");
            String move = sc.nextLine();
            move = move.replace(" ", "");
            char a = move.charAt(0);
            int y = move.()
            boolean validMove
            char
        while(isValidMove(nextMove)){
            
        }
        


    }
    
    public int convertMove(char a){

    }
    */
}