package pl.wr.rss.rssfiz.show.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.wr.rss.rssfiz.show.model.ExampleForm;

public class ExampleValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return ExampleForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "param1",
                "required.param1", "Param1 name is required.");
        
        ExampleForm ef = (ExampleForm)target;
        
        if(ef.getParam2().equals("dupa")){
            errors.rejectValue("param2", "forbiden.word");
        }
    }

}
