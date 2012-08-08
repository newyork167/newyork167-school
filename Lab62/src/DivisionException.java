
public class DivisionException extends Exception {
	public DivisionException(){
		
	}
	
	public DivisionException(String string){
		super(string);
	}
	
	public DivisionException(int num){
		super("Division by 0.0 occured!");
	}
}
