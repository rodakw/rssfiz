package pl.wr.rss.rssfiz.show.math.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.wr.rss.rssfiz.show.math.model.MixedNumber;

public class FractionCalculatorValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return MixedNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "denominator1",
                "required.param1", "Param1 name is required.");
        
        MixedNumber ef = (MixedNumber)target;
        
        if(ef.getOperation().equals("dupa")){
            errors.rejectValue("param2", "forbiden.word");
        }
    }

}
