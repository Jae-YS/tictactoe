public class GameStats{
	int p1losses;
	int p1wins;
	int p1ties;
	double p1percent;

	int p2losses;
	int p2wins;
	int p2ties;
	double p2percent;

	int total;


	GameStats(APlayer p1, APlayer p2){}

	GameStats(APlayer p1){}

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
		return "Thanks for playing!\r\n Overall record: "+this.p1wins+ "-" +this.p1losses+ "-" +this.p1ties+" \n\t (" +this.p1percent+")";
	}
}