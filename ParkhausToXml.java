import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

public class ParkhausToXml {
	public void saveParkhaus(Parkhaus p) {
		XStream xstream = new XStream();
		xstream.alias("Parkhaus", Parkhaus.class);
		xstream.alias("Auto", Auto.class);
		xstream.alias("Kasse", Kasse.class);
		String xml = xstream.toXML(this);
	    FileOutputStream fos = null;
	    try{            
	        fos = new FileOutputStream(p.name + ".xml");
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
