package bankapp.api;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinimumLengthConstraint implements ConstraintValidator<MinLength, String>{
	
	private int limit ;
	public void initialize(MinLength minLength) {
		this.limit=minLength.limit();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value.trim().length()>= limit) {
			return true;
		} 
		return false;
		
		
		
	}




}
