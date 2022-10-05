public class GameStats2P extends GameStats {
    int p2losses;
	int p2wins;
	int p2ties;

    GameStats2P(APlayer p1, APlayer p2){
        super(p1);
    }

	void p1recordLoss(){
		this.p1losses++;
		this.p2wins++;

		this.total++;
	}
	void recordTie(){
		this.p1ties++;
		this.p2ties++;
		total++;

	}
	void p1recordWin(){
		this.p1wins++;
		this.p2losses++;


		this.total++;
	}
    public String toString(){
        return "Thanks for playing!\r\nP1 overall record (W-L-T): "+this.p1wins+ "-" +this.p1losses+ "-" +this.p1ties+"\n\t"+(100*(double)this.p1wins/this.total)+"% games won out of "+this.total+ " \r\nP2 overall record (W-L-T): "+this.p2wins+ "-" +this.p2losses+ "-" +this.p2ties+" \n\t "+(100*(double)this.p2wins/this.total)+"% games won out of "+this.total;
    }
}
