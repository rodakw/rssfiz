package pl.wr.rss.rssfiz.show.math;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeControler {

	@RequestMapping(method = RequestMethod.GET)
    public String viewForm(Model model) {

        return "home";
    }
}
