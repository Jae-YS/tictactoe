public class CpuPlayer extends APlayer{

    CpuPlayer(Game game, char symbol){
        super(game, symbol);
        
    }

    public Move pickMove(){
        int row;
        int col; 
        Move nextMove;
        do{
            row = (int)(Math.random() * game.boardSize);
            col = (int)(Math.random() * game.boardSize); 
            nextMove = new Move(row,col);
        } while(!game.isValidMove(nextMove));

        char representRow = (char) (row+=65);
        int representCol = col+1;

        System.out.println("The CPU's next move is " +representRow+representCol);
        return nextMove; 
    }
}