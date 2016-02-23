package pl.wr.rss.rssfiz.show;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String home() {
        return "guestbook";
    }

    @RequestMapping("/dupa")
    public String home2(ModelMap model) {

        model.addAttribute("movie", "xxx");
        model.addAttribute("message", "yyy");

        return "dupa";
    }
    
    @RequestMapping("/dupa2")
    public ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

            ModelAndView model = new ModelAndView("HelloWorldPage");
            model.addObject("msg", request.getParameter("cos"));
            
            return model;
        }

}