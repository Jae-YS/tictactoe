public class GameStats{
	int nlosses;
	int total;
	int nwins;
	int nties;
	double percent;

	GameStats(){
		this.nlosses = 0;
		this.nties = 0;
		this.nwins = 0;
		this.percent = 0;
		this.total = 0;

	}
	void recordLoss(){
		this.nlosses++;
		this.total++;
		this.percent = (double)this.nwins/(double)this.total;
	}
	void recordTie(){
		nties++;
		total++;
	}
	void recordWin(){
		nwins++;
		total++;
	}

	public String toString(){
		return "Thanks for playing!\r\n Overall record: "+this.nwins+ "-" +this.nlosses+ "-" +this.nties+" \n\t (" +this.percent+")";
	}
}