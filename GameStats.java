public class GameStats{
	int p1losses;
	int p1wins;
	int p1ties;

	int total;

	GameStats(APlayer p1){
	}

	void p1recordLoss(){
		this.p1losses++;

		this.total++;
	}
	void recordTie(){
		this.p1ties++;
		total++;

	}
	void p1recordWin(){
		this.p1wins++;


		this.total++;
	}

	public String toString(){
		return "Thanks for playing!\r\n Your overall record (W-L-T): "+this.p1wins+ "-" +this.p1losses+ "-" +this.p1ties+" \n\t"+(100*(double)this.p1wins/this.total)+"% games won out of "+this.total;
	}
}