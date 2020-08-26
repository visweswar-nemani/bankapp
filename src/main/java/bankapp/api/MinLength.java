package bankapp.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Constraint(validatedBy = { MinimumLengthConstraint.class })
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MinLength {
	
	String message() default "Minimum limit not met";
	int limit() default 3;
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
