import java.io.*;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

public class Parkhaus {
	public String name;
	private int anzahlParkplaetze;
	private int anzahlParkplaetzeFrei;
	private Kasse kasse;
	private ArrayList<Auto> autos = new ArrayList<Auto>();

	public Parkhaus(String name, int anzahlParkplaetze, double preis) {
		this.name = name;
		this.anzahlParkplaetze = anzahlParkplaetze;
		this.anzahlParkplaetzeFrei = this.anzahlParkplaetze;
		this.kasse = new Kasse(preis);
	}

	public int getAnzahlParkplaetze() {
		return anzahlParkplaetze;
	}

	public int getAnzahlParkplaetzeFrei() {
		return anzahlParkplaetzeFrei;
	}

	public void einfahren(Auto auto) {
		if (this.anzahlParkplaetzeFrei > 0) {
			this.anzahlParkplaetzeFrei--;
			autos.add(auto);
			auto.setEinfahrt();
		} else {
			throw new FehlerException();
		}
	}

	public void ausfahren(Auto auto) {
		if (autos.contains(auto)) {
			auto.setAusfahrt();
			kasse.gebuehr(auto);
			autos.remove(auto);
			this.anzahlParkplaetzeFrei++;
		} else {
			throw new FehlerException();
		}
	}
	
	public void saveParkhaus() {
		XStream xstream = new XStream();
		xstream.alias("Parkhaus", Parkhaus.class);
		xstream.alias("Auto", Auto.class);
		xstream.alias("Kasse", Kasse.class);
		String xml = xstream.toXML(this);
	    FileOutputStream fos = null;
	    try{            
	        fos = new FileOutputStream(this.name + ".xml");
//	        fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
	        byte[] bytes = xml.getBytes("UTF-8");
	        fos.write(bytes);

	    }catch (Exception e){
	        System.err.println("Error in XML Write: " + e.getMessage());
	    }
	    finally{
	        if(fos != null){
	            try{
	                fos.close();
	            }catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	public static Parkhaus einlesen(String name){
		File xmlFile = new File(name + ".xml");
		XStream xstream = new XStream();
		return (Parkhaus) xstream.fromXML(xmlFile);
	}
}
