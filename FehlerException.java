
public class FehlerException extends RuntimeException{
	public FehlerException(){
		super("FEHLER");
	}
	
	public FehlerException (String s) {
		super(s);
	}

}
