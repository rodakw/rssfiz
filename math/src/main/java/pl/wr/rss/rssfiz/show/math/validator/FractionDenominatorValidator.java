package pl.wr.rss.rssfiz.show.math.validator;

import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FractionDenominatorValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Long.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        @SuppressWarnings("unchecked")
        Map<String, Number> map = (Map<String, Number>) target;

        int num = (int) map.get("number");
        Long value = (Long) map.get("value");

        switch (num) {
        case 1:
            if (value == null) {
                errors.rejectValue("denominator1", "required.denominator1");
            } else if (value.equals(0L)) {
                errors.rejectValue("denominator1", "denominator1.zero");
            }
            break;
        case 2:
            if (value == null) {
                errors.rejectValue("denominator2", "required.denominator2");
            } else if (value.equals(0L)) {
                errors.rejectValue("denominator2", "denominator2.zero");
            }
            break;

        default:
            break;
        }

    }

}
