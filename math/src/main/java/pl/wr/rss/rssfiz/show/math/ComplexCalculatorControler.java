package pl.wr.rss.rssfiz.show.math;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.wr.math.number.Complex;
import pl.wr.rss.rssfiz.show.math.model.ComplexNumber;
import pl.wr.rss.rssfiz.show.math.util.CalculatorConstans;

@Controller
@RequestMapping("/complexCalculator")
public class ComplexCalculatorControler {

    @RequestMapping(method = RequestMethod.GET)
    public String viewForm(Model model) {

        ComplexNumber complexNumber = new ComplexNumber();
        complexNumber.setOperation("+");

        model.addAttribute("myData", complexNumber);

        return "complexCalculator";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String calculateForm(@ModelAttribute("myData") ComplexNumber myData, BindingResult result, Model model) {

        Double real1 = myData.getReal1();
        Double real2 = myData.getReal2();
        Double imaginary1 = myData.getImaginary1();
        Double imaginary2 = myData.getImaginary2();
        String operation = myData.getOperation();

        Complex resultComplex = null;

        Complex x = makeComplex(real1, imaginary1, CalculatorConstans.FIRST_NUMBER, result);
        Complex y = makeComplex(real2, imaginary2, CalculatorConstans.SECOND_NUMBER, result);

        switch (operation) {
        case "+":
            resultComplex = Complex.add(x, y);
            break;
        case "-":
            resultComplex = Complex.substract(x, y);
            break;
        case "*":
            resultComplex = Complex.multiply(x, y);
            break;
        case "/":
            if (y.intValue() == 0) {
                result.reject("number2.required");
                return "complexCalculator";
            } else {
                resultComplex = Complex.divide(x, y);
            }
            break;

        default:
            return "complexCalculator";
        }

        model.addAttribute("result", resultComplex);
        model.addAttribute("doubleResult", resultComplex.doubleValue());

        return "complexCalculator";
    }

    private Complex makeComplex(Double real, Double imaginary, int toValidate, BindingResult errors) {

        boolean isR = real != null;
        boolean isI = imaginary != null;

        if (!isR && !isI) {
            return Complex.ZERO;
        } else if (isR && !isI) {
            return new Complex(real, 0);
        } else if (!isR && isI) {
            return new Complex(0, imaginary);
        } else {
            return new Complex(real, imaginary);
        }

    }
}
