public class CpuPlayer extends APlayer{

    CpuPlayer(Game game, char symbol){
        super(game, symbol);
        
    }

    public Move pickMove(){
        return new Move(1,1); 
    }
    /*public Move pickMove(){
        int row = (Math.random() * game.boardSize);
        int col = (Math.random() * game.boardSize); 
        Move nextMove = new Move(row,col)
        while(!game.isValidMove(nextMove)){
            row = (Math.random() * 3);
            col = (Math.random() * 3); 
            
        } 
        row+=65;

        System.out.println("The CPU's next move is" +row+col);
        return nextMove; 
    }
    */
}