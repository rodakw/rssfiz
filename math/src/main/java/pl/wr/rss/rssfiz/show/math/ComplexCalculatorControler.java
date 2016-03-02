package pl.wr.rss.rssfiz.show.math;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.wr.rss.rssfiz.show.math.model.ComplexNumber;

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
}
