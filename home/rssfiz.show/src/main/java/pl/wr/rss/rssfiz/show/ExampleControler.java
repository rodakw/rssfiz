package pl.wr.rss.rssfiz.show;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.wr.rss.rssfiz.show.model.ExampleForm;

@Controller
@RequestMapping("/exampleForm")
public class ExampleControler {

    @RequestMapping(method = RequestMethod.GET)
    public String viewForm(Model model) {

        ExampleForm em = new ExampleForm();
        model.addAttribute("myData", em);

        return "exampleForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String calculateForm(@ModelAttribute("myData") ExampleForm myData, Model model) {

        model.addAttribute("result", myData.getParam1() + myData.getParam2() + myData.getParam3() + myData.getParam4());

        return "exampleForm";
    }

}
