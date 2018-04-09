//This is An IllegalDate212Exception extends IllegalargumentException class.
//this class willl catch any error if there is any invalid date in the inpute file
//since I already collecting all valid date by using IsIvalid method therefore IllegalDate212Exception will not find anything for displaying error 
public class IllegalDate212Exception extends IllegalArgumentException {

	public IllegalDate212Exception(){
		
	}
	
	public IllegalDate212Exception(String err){
		super(err);
	}
}
