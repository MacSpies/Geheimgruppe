import java.util.Date;

public class ManagerViewTag {
	private double einnahmen = 0.0;
	private Date d = new Date();
	
	public void setEinnahmen(double gebuehr) {
		Date d1 = new Date();
		if(d1.getTime() > d.getTime() + 24*60*60*1000) {
			this.einnahmen = 0.0;
			this.d = d1;
		}
		this.einnahmen += gebuehr;
	}

	public double getEinnahmen() {
		return this.einnahmen;
	}

}
