public abstract class APlayer{
    protected Game game;
    protected char symbol;

    APlayer(){}
    APlayer(Game game, char symbol){
        this.game = game;
        this.symbol = symbol;
    }

    public char getSymbol(){
        return this.symbol;
    }

    abstract public Move pickMove();

}
