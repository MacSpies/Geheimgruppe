
public class Kasse {
	private double preis;
	private double einnahmen = 0.0;
	private int anzahlAutos = 0;
	
	public Kasse (double preis) {
		this.preis = preis;
	}
	public double gebuehr(Auto auto) {
		this.anzahlAutos++;
		this.einnahmen += auto.dauer() / 10 * preis;
		auto.setGebuehr(auto.dauer() / 10 * preis);
		return auto.dauer() / 10 * preis;
	}
	public double getEinnahmen() {
		return einnahmen;
	}
	public int getAnzahlAutos() {
		return anzahlAutos;
	}
	

}
