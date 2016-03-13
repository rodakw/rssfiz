package pl.wr.rss.rssfiz.show.math;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.wr.math.number.BigFraction;
import pl.wr.math.number.Fraction;
import pl.wr.rss.rssfiz.show.math.model.MixedBigNumber;
import pl.wr.rss.rssfiz.show.math.validator.FractionDenominatorValidator;

@Controller
@RequestMapping("/bigFractionCalculator")
public class BigFractionCalculatorControler {
    
    private int FIRST_NUMBER = 1;
    private int SECOND_NUMBER = 2;
    
    @Autowired
    FractionDenominatorValidator fractionDenominatorValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String viewForm(Model model) {

	    MixedBigNumber mixedNumber = new MixedBigNumber();
        mixedNumber.setOperation("+");

        model.addAttribute("myData", mixedNumber);

		return "bigFractionCalculator";
	}
	
	   @RequestMapping(method = RequestMethod.POST)
	    public String calculateForm(@ModelAttribute("myData") MixedBigNumber myData, BindingResult result, Model model) {

	        Long total1 = myData.getTotal1();
	        Long total2 = myData.getTotal2();
	        BigInteger numerator1 = myData.getNumerator1();
	        BigInteger numerator2 = myData.getNumerator2();
	        BigInteger denominator1 = myData.getDenominator1();
	        BigInteger denominator2 = myData.getDenominator2();
	        Integer decimalPower1 = myData.getDecimalPower1();
	        Integer decimalPower2 = myData.getDecimalPower2();
	        String operation = myData.getOperation();

	        BigFraction resultFraction = null;
	        BigFraction x = makeFraction(total1, numerator1, denominator1, decimalPower1, FIRST_NUMBER, result);
	        BigFraction y = makeFraction(total2, numerator2, denominator2, decimalPower2, SECOND_NUMBER, result);

	        switch (operation) {
	        case "+":
	            resultFraction = BigFraction.add(x, y);
	            break;
	        case "-":
	            resultFraction = BigFraction.subtract(x, y);
	            break;
	        case "*":
	            resultFraction = BigFraction.multiply(x, y);
	            break;
	        case "/":
	            if (y.isZero()) {
	                result.reject("number2.required");
	                return "fractionCalculator";
	            } else {
	                resultFraction = BigFraction.divide(x, y);
	            }
	            break;

	        default:
	            return "bigFractionCalculator";
	        }

	        long longResult = resultFraction.longValue();

	        model.addAttribute("result", resultFraction);
	        model.addAttribute("doubleResult", resultFraction.doubleValue());
	        
	        if (resultFraction.getUncertainty() == BigFraction.UNKNOWN) {
	            model.addAttribute("approximate", true);
	        }

	        if (longResult != 0) {
	            model.addAttribute("longResult", resultFraction.longValue());
	            resultFraction = BigFraction.subtract(resultFraction, new BigFraction(resultFraction.longValue()));
	        }

	        if (!resultFraction.getNumerator().equals(BigInteger.ZERO)) {
	            model.addAttribute("numerator", resultFraction.getNumerator());
	            model.addAttribute("denominator", resultFraction.getDenominator());
	        }
	        if (!resultFraction.getNumerator().equals(BigInteger.ZERO) || longResult != 0) {
	            model.addAttribute("isResult", true);
	        }

//	        int decimalPower = resultFraction.getDecimalPower();

//	        if (decimalPower != 0) {
//	            model.addAttribute("decimalPower", resultFraction.getDecimalPower());
//	            if (decimalPower > 0) {
//	                model.addAttribute("numeratorExt", (long) (resultFraction.getNumerator() * Math.pow(10, decimalPower)));
//	                model.addAttribute("denominatorExt", resultFraction.getDenominator());
//	            } else {
//	                model.addAttribute("numeratorExt", (resultFraction.getNumerator()));
//	                model.addAttribute("denominatorExt",
//	                        (long) (resultFraction.getDenominator() * Math.pow(10, Math.abs(decimalPower))));
//	            }
//	        }

	        return "bigFractionCalculator";
	    }

    private BigFraction makeFraction(Long total, BigInteger numerator, BigInteger denominator, Integer decimalPower, int toValidate, BindingResult errors) {
       
        
        boolean isT = total != null;
        boolean isN = numerator != null;
        boolean isP = decimalPower != null;

        if (!isT && !isN && !isP) {
            return BigFraction.ZERO;
        } else if (isT && !isN && !isP) {
            return new BigFraction(total);
        } else if (isT && !isN & isP) {
            return new BigFraction(total, 0, 1, decimalPower);
        } else if (!isT && isN & !isP) {
            validateDenominator(denominator, toValidate, errors);
            if (!errors.hasErrors()) {
                return new BigFraction(numerator, denominator);
            }
        } else if (!isT && isN & isP) {
            validateDenominator(denominator, toValidate, errors);
            if (!errors.hasErrors()) {
                return new BigFraction(numerator, denominator, decimalPower);
            }
//        } else if (isT && isN & !isP) {
//            validateDenominator(denominator, toValidate, errors);
//            if (!errors.hasErrors()) {
//                return new BigFraction(total, numerator, denominator, 0);
//            }
//        } else {
//            validateDenominator(denominator, toValidate, errors);
//            if (!errors.hasErrors()) {
//                return new BigFraction(total, numerator, denominator, decimalPower);
//            }
        }
        return BigFraction.ZERO;
    }
    
    private void validateDenominator(BigInteger denominator, Integer toValidate, BindingResult errors) {

        Map<String, Number> map = new HashMap<String, Number>();
        map.put("value", denominator);
        map.put("number", toValidate);

        fractionDenominatorValidator.validate(map, errors);
    }
}
