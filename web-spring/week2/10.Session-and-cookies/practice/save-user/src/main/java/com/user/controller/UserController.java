package com.user.controller;

import com.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//store information of a model attribute name "user" in the session
@SessionAttributes("user")
public class UserController {
    //add user in model attribute
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    //get a cookie as variable
    @RequestMapping("/login")
    //automatically link cookie "setUser" to the string setUser
    //when spring map request it checks with http that give a cookie with the name of setUser and
    //map it to String variable setUser if this cookie
    //to avoid a missing cookie value exception when there is no cookie we add a default value
    // parameter
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUserCookie,
                        Model model) {
        Cookie cookie = new Cookie("setUser", setUserCookie);
        //add a cookie
        model.addAttribute("cookieValue", cookie);
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value =
            "setUser", defaultValue = "") String setUserCookie, HttpServletRequest request,
                          HttpServletResponse response)  {
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
            if (user.getEmail() != null)
                setUserCookie = user.getEmail();
            //create cookie and add cookie to response
            Cookie cookie = new Cookie("setUser", setUserCookie);
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);

            //get all cookie
            Cookie[] cookies = request.getCookies();
            for (Cookie ck : cookies) {
                //display only cookie with the name 'setUser'
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue",ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue",ck);
                    break;
                }
            }
            model.addAttribute("message","login success. welcome");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUserCookie);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message","login failed. try again");
        }
        return "login";
    }
}
