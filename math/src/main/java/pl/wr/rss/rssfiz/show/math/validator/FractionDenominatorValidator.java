package pl.wr.rss.rssfiz.show.math.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigInteger;
import java.util.Map;

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
        Object value = map.get("value");
        Object valueZero = null;
        if (value instanceof Long) {
            value = (Long) map.get("value");
            valueZero = 0L;
        } else if (value instanceof BigInteger) {
            value = (BigInteger) map.get("value");
            valueZero = BigInteger.ZERO;
        }

        switch (num) {
        case 1:
            if (value == null) {
                errors.rejectValue("denominator1", "required.denominator1");
            } else if (value.equals(valueZero)) {
                errors.rejectValue("denominator1", "denominator1.zero");
            }
            break;
        case 2:
            if (value == null) {
                errors.rejectValue("denominator2", "required.denominator2");
            } else if (value.equals(valueZero)) {
                errors.rejectValue("denominator2", "denominator2.zero");
            }
            break;

        default:
            break;
        }

    }

}
