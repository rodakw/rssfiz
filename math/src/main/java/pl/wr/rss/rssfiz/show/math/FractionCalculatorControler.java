package pl.wr.rss.rssfiz.show.math;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.wr.math.number.Fraction;
import pl.wr.rss.rssfiz.show.math.model.MixedNumber;
import pl.wr.rss.rssfiz.show.math.util.CalculatorConstans;
import pl.wr.rss.rssfiz.show.math.validator.FractionDenominatorValidator;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/fractionCalculator")
public class FractionCalculatorControler {

    private final FractionDenominatorValidator fractionDenominatorValidator;

    public FractionCalculatorControler(FractionDenominatorValidator fractionDenominatorValidator) {
        this.fractionDenominatorValidator = fractionDenominatorValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewForm(Model model) {

        MixedNumber mixedNumber = new MixedNumber();
        mixedNumber.setOperation("+");

        model.addAttribute("myData", mixedNumber);

        return "fractionCalculator";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String calculateForm(@ModelAttribute("myData") MixedNumber myData, BindingResult result, Model model) {

        Long total1 = myData.getTotal1();
        Long total2 = myData.getTotal2();
        Long numerator1 = myData.getNumerator1();
        Long numerator2 = myData.getNumerator2();
        Long denominator1 = myData.getDenominator1();
        Long denominator2 = myData.getDenominator2();
        Integer decimalPower1 = myData.getDecimalPower1();
        Integer decimalPower2 = myData.getDecimalPower2();
        String operation = myData.getOperation();

        Fraction resultFraction;
        Fraction x = makeFraction(total1, numerator1, denominator1, decimalPower1, CalculatorConstans.FIRST_NUMBER, result);
        Fraction y = makeFraction(total2, numerator2, denominator2, decimalPower2, CalculatorConstans.SECOND_NUMBER, result);

        switch (operation) {
            case "+":
                resultFraction = Fraction.add(x, y);
                break;
            case "-":
                resultFraction = Fraction.subtract(x, y);
                break;
            case "*":
                resultFraction = Fraction.multiply(x, y);
                break;
            case "/":
                if (y.isZero()) {
                    result.reject("number2.required");
                    return "fractionCalculator";
                } else {
                    resultFraction = Fraction.divide(x, y);
                }
                break;

            default:
                return "fractionCalculator";
        }

        long longResult = resultFraction.longValue();

        model.addAttribute("result", resultFraction);
        model.addAttribute("doubleResult", resultFraction.doubleValue());

        if (resultFraction.getUncertainty() == Fraction.UNKNOWN) {
            model.addAttribute("approximate", true);
        }

        if (longResult != 0) {
            model.addAttribute("longResult", resultFraction.longValue());
            resultFraction = Fraction.subtract(resultFraction, new Fraction(resultFraction.longValue()));
        }

        if (resultFraction.getNumerator() != 0) {
            model.addAttribute("numerator", resultFraction.getNumerator());
            model.addAttribute("denominator", resultFraction.getDenominator());
        }
        if (resultFraction.getNumerator() != 0 || longResult != 0) {
            model.addAttribute("isResult", true);
        }

        int decimalPower = resultFraction.getDecimalPower();

        if (decimalPower != 0) {
            model.addAttribute("decimalPower", resultFraction.getDecimalPower());
            if (decimalPower > 0) {
                model.addAttribute("numeratorExt", (long) (resultFraction.getNumerator() * Math.pow(10, decimalPower)));
                model.addAttribute("denominatorExt", resultFraction.getDenominator());
            } else {
                model.addAttribute("numeratorExt", (resultFraction.getNumerator()));
                model.addAttribute("denominatorExt", (long) (resultFraction.getDenominator() * Math.pow(10, Math.abs(decimalPower))));
            }
        }

        return "fractionCalculator";
    }

    private Fraction makeFraction(Long total, Long numerator, Long denominator, Integer decimalPower, int toValidate, BindingResult errors) {

        boolean isT = total != null;
        boolean isN = numerator != null;
        boolean isP = decimalPower != null;

        if (!isT && !isN && !isP) {
            return Fraction.ZERO;
        } else if (isT && !isN && !isP) {
            return new Fraction(total);
        } else if (isT && !isN & isP) {
            return new Fraction(total, 0, 1, decimalPower);
        } else if (!isT && isN & !isP) {
            validateDenominator(denominator, toValidate, errors);
            if (!errors.hasErrors()) {
                return new Fraction(numerator, denominator);
            }
        } else if (!isT && isN & isP) {
            validateDenominator(denominator, toValidate, errors);
            if (!errors.hasErrors()) {
                return new Fraction(numerator, denominator, decimalPower);
            }
        } else if (isT && isN & !isP) {
            validateDenominator(denominator, toValidate, errors);
            if (!errors.hasErrors()) {
                return new Fraction(total, numerator, denominator, 0);
            }
        } else {
            validateDenominator(denominator, toValidate, errors);
            if (!errors.hasErrors()) {
                return new Fraction(total, numerator, denominator, decimalPower);
            }
        }
        return Fraction.ZERO;
    }

    private void validateDenominator(Long denominator, Integer toValidate, BindingResult errors) {

        Map<String, Number> map = new HashMap<>();
        map.put("value", denominator);
        map.put("number", toValidate);

        fractionDenominatorValidator.validate(map, errors);
    }

}
