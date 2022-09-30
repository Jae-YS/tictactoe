public class CpuPlayer extends APlayer{

    CpuPlayer(Game game, char symbol){
        super(game, symbol);
        
    }

    public Move pickMove(){
        int row = (int)(Math.random() * game.boardSize);
        int col = (int)(Math.random() * game.boardSize); 
        Move nextMove = new Move(row,col);
        while(!game.isValidMove(nextMove)){
            row = (int)(Math.random() * 3);
            col = (int)(Math.random() * 3); 
            
        } 
        char represent = (char) (row+=65);

        System.out.println("The CPU's next move is " +represent+col);
        return nextMove; 
    }
}