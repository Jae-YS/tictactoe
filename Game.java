import java.util.Scanner;

public class Game{

    final int boardSize = 3;
    char[][] board;
    APlayer[] players = new APlayer[2];
    private char SYMBOL_BLANK = ' ';
    private char SYMBOL_CPU = 'O';
    private char SYMBOL_HUMAN = 'X';

    Game(){
        this.board = new char[3][3];
        for(int i=0;i<board.length;i++){
            for(int y=0;y<board[i].length;y++){
                board[i][y] = ' ';
            }  
        }
    }

    public int getBoardSize(){
        return this.boardSize;
    }

    //check if the human move is valid
    public boolean isValidMove(Move move){
        if (this.board[move.row][move.col] == ' ') return true;
        else return false;
    }

    protected void executeMove(Move move, char symbol){
	    this.board[move.row][move.col] = symbol;
    }

    public void getGameStatus(){
    
    }

    protected void resetGame(){
        for(int i=0;i<this.board.length;i++){
            for(int y=0;y<this.board[i].length;y++){
		board[i][y] = this.SYMBOL_BLANK; 
            } 
        }
    }

    public String toString(){
        String s = "  ";
        String[] letters = {"A","B","C"};
	    int let = 0;
	    for(int nums = 1; nums <= this.boardSize; nums++) {
            s += nums + "   ";
        }

	    for(int r = 0; r < this.boardSize - 1; r++) {
            //letters & x's
            s += "\r\n" + letters[let] + " ";
            for(int c = 0; c < this.boardSize - 1; c++) {
                s += this.board[r][c] + " | ";
            }
            s += board[r][boardSize - 1] + "\r\n" + " ";
            //dashes
            for(int c = 0; c < this.boardSize - 1; c++) {
                s += "---|";
            }
            s += "---";
            let++;
        }

        //last row of letters & x's
        s += "\r\n" + letters[this.boardSize - 1] + " ";
        for(int c = 0; c < this.boardSize - 1; c++) {
            s += this.board[this.boardSize - 1][c] + " | ";
        }
        s += this.board[this.boardSize - 1][this.boardSize - 1] + "\r\n" + " ";

        return s += "\r\n";
    }

    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);

        //beginning the game
        System.out.println("Enter 'S' to begin");
        String start = sc.nextLine();
        while(!start.equalsIgnoreCase("s")){
            System.out.println("Try again. Enter 'S' to begin");
            start = sc.nextLine();
        }
        boolean runGame = true;

        //determining who goes first
        System.out.println("Randomly choosing");
        Game gameboard = new Game();
        System.out.println(gameboard.toString()); 
        /*Player p1 = new HumanPlayer();
        Player p2 = new CpuPlayer();
        int whoFirst = (Math.random() * 1);
        if(whoFirst == 0){
            players[0] = p1;
            players[1] = p2;

        }
        else{
            players[0] = p2;
            players[1] = p1;
        }
        
        int whoplays = 0;
        //running the game
        while(runGame){
	    System.out.println(this.gameboard);
            System.out.println(players[whoplays]);
            Move nextMove = players[whoplays].pickMove;
	    break; 
        */
             
    }

}



