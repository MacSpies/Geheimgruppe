
public class KundenView {
	private Auto a;
	
	public KundenView(Auto a) {
		this.a = a;
	}
	
	public double getEinnahmen() {
		return this.a.getGebuehr();
	}
}
