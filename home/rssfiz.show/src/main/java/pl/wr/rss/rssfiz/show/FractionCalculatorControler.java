package pl.wr.rss.rssfiz.show;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.wr.math.number.Fraction;
import pl.wr.rss.rssfiz.show.model.MixedNumber;

@Controller
@RequestMapping("/fractionCalculator")
public class FractionCalculatorControler {

    @RequestMapping(method = RequestMethod.GET)
    public String viewForm(Model model) {

    	MixedNumber em = new MixedNumber();
        model.addAttribute("myData", em);

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
    	 
    	 Fraction outcome = null;
    	 Fraction x = new Fraction(total1, numerator1, denominator1, decimalPower1);
         Fraction y = new Fraction(total2, numerator2, denominator2, decimalPower2);
    	 
    	 switch (operation) {
         case "+":
        	 outcome = Fraction.add(x, y);
             break;
         case "-":
        	 outcome = Fraction.subtract(x, y);
             break;
         case "*":
        	 outcome = Fraction.multiply(x, y);
             break;
         case "/":
        	 outcome = Fraction.divide(x, y);
             break;

         default:
             break;
         }
    	 
            model.addAttribute("result",outcome);

        return "fractionCalculator";
    }

}
