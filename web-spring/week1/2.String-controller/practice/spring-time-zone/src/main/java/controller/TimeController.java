package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/worldclock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false
            , defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);

        //Calculate locale time by get current time plus the difference between two time zone
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        //set local time to locale time that was calculated
        date.setTime(locale_time);

        //data binding
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
