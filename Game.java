import java.util.Scanner;

public class Game{

    final int boardSize = 3;
    char[][] board;
    APlayer[] players = new APlayer[2];
    private char SYMBOL_BLANK = ' ';
    private char SYMBOL_1 = 'O';
    private char SYMBOL_2 = 'X';

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

    public char getGameStatus(){
        /*
         * return 'O' if you can still play the game
         * return '1' if player 1 won
         * return '2' if player 2 won
         * return 'T' if the game is a tie
         * return 'Q' if user quits the game; 
         */
        
        //check vertical
        for(int i=0;i<board.length;i++){
            for(int y=0;y<board[i].length;y++){

            }
        }
        

        //check horizontal

        //check diagonal

        return '0';
    }

    /*
     * Resets the game board by replacing all 'X' and 'O' to ' '
     */
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

    public char playGame(APlayer[] players){
        int whoPlays = 0;
        char keepPlaying = ' '; 
        while(true){
            if(whoPlays == 2) whoPlays = 0;
            System.out.println(toString());
            Move nextMove = players[whoPlays].pickMove();
            if(nextMove == null) return 'Q';
            executeMove(nextMove, players[whoPlays].symbol);
	        keepPlaying = this.getGameStatus(); 
            if(keepPlaying != '0') break;
            whoPlays++; 
        }
        return keepPlaying;
    }
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);

        //beginning the game
        System.out.println("Welcome to TicTacToe! \nEnter S to begin");
        String start = sc.nextLine();
        while(!start.equalsIgnoreCase("s")){
            System.out.println("Try again. Enter 'S' to begin");
            start = sc.nextLine();
        }
        System.out.println("One Player (1) or Two Player (2)?\nEnter a number");
        int option = sc.nextInt();
        while(option != 1 && option != 2){
            System.out.println("Try again. Enter a number 1 or 2"); 
            option = sc.nextInt();
        }

        //determining who goes first
        System.out.println("\nRandomly choosing who goes first...");
        Game gameboard = new Game();
        APlayer p1;
        APlayer p2;
        GameStats stats;
        if(option == 1 ){
            p1 = new HumanPlayer(gameboard, gameboard.SYMBOL_1);
            p2 = new CpuPlayer(gameboard, gameboard.SYMBOL_2);
            stats = new GameStats(p1);
        }
        else{
            p1 = new HumanPlayer(gameboard, gameboard.SYMBOL_1);
            p2 = new HumanPlayer(gameboard, gameboard.SYMBOL_2);
            stats = new GameStats(p1, p2);
        }
        int whoFirst = (int)(Math.random() * 1);
        if(whoFirst == 0){
            gameboard.players[0] = p1;
            gameboard.players[1] = p2;

        }
        else{
            gameboard.players[0] = p2;
            gameboard.players[1] = p1;
        }
    
        boolean game = true; 
        //running the game
        while(game){
            char result = gameboard.playGame(gameboard.players);
            switch(result){
                case '1':
                    if(gameboard.players[0] instanceof HumanPlayer && gameboard.players[1] instanceof HumanPlayer) stats.p1recordWin();
                    //check to see if this works? else I need to have two separate methods to see if they are  p1 vs p2 or p1 vs cpu
                    else stats.p1recordWin();
                    break;
                case '2':
                    if(gameboard.players[0] instanceof HumanPlayer && gameboard.players[1] instanceof HumanPlayer) stats.p1recordLoss();
                    else stats.p1recordLoss();
                    break;
                case 'T':
                    stats.recordTie();
                    break;
                default: 
                    game = false;
                    break;
            }
        }

        System.out.println(stats);
    }
}



