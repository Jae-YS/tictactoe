import java.util.Scanner;

public class Game{

    final int boardSize = 3;
    char[][] board;
    APlayer[] players = new APlayer[2];
    private char SYMBOL_BLANK = ' ';
    private char SYMBOL_1 = 'O';
    private char SYMBOL_2 = 'X';
    int numberOfPlayer = 0;

    Game(){
        this.board = new char[3][3];
        for(int i=0;i<board.length;i++){
            for(int y=0;y<board[i].length;y++){
                board[i][y] = ' ';
            }  
        }
    }

    public void setNumberOfPlayer(int x){
        this.numberOfPlayer = x;
    }

    //check if the human/computer move is valid
    public boolean isValidMove(Move move){
        if (move.row == -1 || move.col == -1) return false;
        
    
        if (this.board[move.row][move.col] == ' ') return true;
        else return false;
    }

    protected void executeMove(Move move, char symbol){
	    this.board[move.row][move.col] = symbol;
    }

    public char getGameStatus(char playerSymbol){
        /*
         * return '0' if you can still play the game
         * return 'O' if player 1 won
         * return 'X' if player 2 won
         * return 'T' if the game is a tie
         * return 'Q' if user quits the game; 
         */

        //check vertical
        int count = 0; 
        for(int i=0;i<this.boardSize;i++){
            for(int y=0;y<this.boardSize;y++){
                if(board[i][y] == playerSymbol) count++;
            }
            if(count == boardSize) return playerSymbol;
            count = 0;
        }

        //check horizontal
        for(int i=0;i<this.boardSize;i++){
            for(int y=0;y<this.boardSize;y++){
                if(board[y][i] == playerSymbol) count++;
            }
            if(count == boardSize) return playerSymbol;
            count = 0;
        }

        //check diagonal left to right
        for(int i = 0; i<this.boardSize; i++){
            if(board[i][i] == playerSymbol) count++;
        }
        if(count == boardSize) return playerSymbol;
        count = 0;

        //check diagonal right to left
        int j = 0;
        for(int i = this.boardSize-1; i> -1 ; i--){
            if(board[j][i] == playerSymbol) count++;
            j++;
        }
        if(count == boardSize) return playerSymbol;
        count = 0;

        //check for full board
        boolean fullBoard = true; 
        for(int i=0;i<this.boardSize;i++){
            for(int y=0;y<this.boardSize;y++){
                if(board[i][y] == ' ') fullBoard = false;
            }
        }
        if(fullBoard) return 'T'; 

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

    public void switchOrder(APlayer[] players, Result result){
        APlayer store;
        if(result.getResult() == result.getFirst()){
            store = players[0];
            players[0] = players[1]; 
            players[1] = store;
        }
    }

    public char playGame(APlayer[] players){
        int whoPlays = 0;
        char keepPlaying = '0'; 
        while(keepPlaying == '0'){
            if(whoPlays == 2) whoPlays = 0;
            
            System.out.println("\n" + toString());
            Move nextMove = players[whoPlays].pickMove();
            if(nextMove == null){
                return 'Q';
            }

            executeMove(nextMove, players[whoPlays].symbol);
	        keepPlaying = this.getGameStatus(players[whoPlays].getSymbol());
            whoPlays++;
        }
        System.out.println("\n" + toString());
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
        gameboard.setNumberOfPlayer(option);
        if(option == 1 ){
            p1 = new HumanPlayer(gameboard, gameboard.SYMBOL_1);
            p2 = new CpuPlayer(gameboard, gameboard.SYMBOL_2);
            stats = new GameStats(p1);
        }
        else{
            p1 = new HumanPlayer(gameboard, gameboard.SYMBOL_1);
            p2 = new HumanPlayer(gameboard, gameboard.SYMBOL_2);
            stats = new GameStats2P(p1, p2);
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
        Result result = new Result(gameboard.players[0].getSymbol(), ' ');
        while(game){
            result.setResult(gameboard.players[0].getSymbol(), gameboard.playGame(gameboard.players));
            gameboard.resetGame();
            gameboard.switchOrder(gameboard.players,result);
            switch(result.winner){
                case 'O':
                    if(gameboard.numberOfPlayer == 1) System.out.println("Player 1 won the round!");
                    else System.out.println("Player 1 won the round. Player 2 lost the round.");
                    stats.p1recordWin();
                    break;
                case 'X':
                    if(gameboard.numberOfPlayer == 1) System.out.println("CPU won the round!");
                    else System.out.println("Player 2 won the round. Player l lost the round.");
                    stats.p1recordLoss();
                    break;
                case 'Q':
                    game = false;
                    break;
                default: 
                    System.out.println("The round was a tie");
                    stats.recordTie();
                    break;
            }
        }

        System.out.println(stats);
    }
}


