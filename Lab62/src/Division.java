
public class Division {
	
	public double divide(double num1, double num2){
		return num1/num2;
	}
	
	public int divide(int num1, int num2) throws IntegerDivisionException{
		try{
			if(num2 == 0){
				throw new IntegerDivisionException("No zero division, please.");
			}
		} catch(IntegerDivisionException e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.extraPrint("Oh, no, no, no");
			throw new IntegerDivisionException("Third warning: 0 Denominator!");
		}
		return num1/num2;
	}
}
