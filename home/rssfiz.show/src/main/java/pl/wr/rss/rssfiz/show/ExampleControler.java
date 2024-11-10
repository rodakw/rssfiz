package pl.wr.rss.rssfiz.show;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.wr.rss.rssfiz.show.model.ExampleForm;
import pl.wr.rss.rssfiz.show.validator.ExampleValidator;

@Controller
@RequestMapping("/exampleForm")
public class ExampleControler {

    final
    ExampleValidator exampleValidator;

    public ExampleControler(ExampleValidator exampleValidator) {
        this.exampleValidator = exampleValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewForm(Model model) {

        ExampleForm em = new ExampleForm();
        model.addAttribute("myData", em);

        return "exampleForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String calculateForm(@ModelAttribute("myData") ExampleForm myData, BindingResult result, Model model) {

        exampleValidator.validate(myData, result);

        if (!result.hasErrors()) {
            model.addAttribute("result",
                    myData.getParam1() + myData.getParam2() + myData.getParam3() + myData.getParam4());
        }

        return "exampleForm";
    }

}
