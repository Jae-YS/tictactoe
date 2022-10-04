public class GameStats2P extends GameStats {
    int p2losses;
	int p2wins;
	int p2ties;
	double p2percent;

    GameStats2P(APlayer p1, APlayer p2){
        super(p1);
    }

	void p1recordLoss(){
		this.p1losses++;
		this.p2wins++;
		this.p1percent = (double)this.p1wins/(double)this.total;
		this.p2percent = (double)this.p2wins/(double)this.total;

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
		this.p1percent = (double)this.p1wins/(double)this.total;
		this.p2percent = (double)this.p2wins/(double)this.total;

		this.total++;
	}
    public String toString(){
        return "Thanks for playing!\r\nP1 overall record: "+this.p1wins+ "-" +this.p1losses+ "-" +this.p1ties+" \n\t (" +this.p1percent+"%)) \r\nP2 overall record: "+this.p2wins+ "-" +this.p2losses+ "-" +this.p2ties+" \n\t (" +this.p1percent+"%))";
    }
}
