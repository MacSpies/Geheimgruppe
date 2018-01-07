
public class ParkhausController {
	//KundenView wird in der Klasse Auto verwaltet!
	private Parkhaus p;
	private ManagerViewTag v1;
	private ManagerViewWoche v2;
	
	public void setParkhaus(String name, int anzahlParkplaetze, double preis){
		this.p = new Parkhaus(name, anzahlParkplaetze, preis);
	}
	
	public void setManagerViewTag() {
		this.v1 = new ManagerViewTag();
	}
	
	public void setManagerViewWoche() {
		this.v2 = new ManagerViewWoche();
	}
	
	
	public void einfahren(Auto auto) {
		this.p.einfahren(auto);
	}
	
	public void ausfahren(Auto auto) {
		this.p.ausfahren(auto);
		this.v1.setEinnahmen(auto.getGebuehr());
		this.v2.setEinnahmen(auto.getGebuehr());
	}
	
	public Parkhaus getP() {
		return this.p;
	}

	public ManagerViewTag getV1() {
		return this.v1;
	}

	public ManagerViewWoche getV2() {
		return this.v2;
	}

}
