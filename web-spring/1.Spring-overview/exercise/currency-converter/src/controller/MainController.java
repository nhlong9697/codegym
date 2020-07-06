package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @PostMapping("/calculate")
    public ModelAndView calculate(@RequestParam double rate, @RequestParam double usd) {
        ModelAndView modelAndView = new ModelAndView("result");
        double result = rate * usd;
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
