public class Result {
    char winner;
    char whoFirst;

    Result(char whoFirst, char winner){
        this.winner = winner;
        this.whoFirst = whoFirst;
    }

    void setResult(char whoFirst, char winner){
        this.whoFirst = whoFirst;
        this.winner = winner;
    }

    char getFirst(){
        return this.whoFirst;
    }

    char getResult(){
        return this.winner; 
    }

}
