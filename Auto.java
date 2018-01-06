import java.util.Date;

public class Auto {
	private Date einfahrt;
	private Date ausfahrt;
	private double gebuehr;
	
	public void setEinfahrt(){
		einfahrt = new Date();
	}
	public void setAusfahrt(){
		ausfahrt = new Date();
	}
	public void setGebuehr(double gebuehr) {
		this.gebuehr = gebuehr;
	}
	public double getGebuehr() {
		return this.gebuehr;
	}
	public int dauer() {
		if (einfahrt == null || ausfahrt == null) {
			throw new FehlerException();
		}
		return (int)(ausfahrt.getTime() - einfahrt.getTime());
	} 

}
