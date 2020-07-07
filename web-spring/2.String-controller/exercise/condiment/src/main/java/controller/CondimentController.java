package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {
    @GetMapping("/")
    String getIndex() {
        return "index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment) {

    }
}
