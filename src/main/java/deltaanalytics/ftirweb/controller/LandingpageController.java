package deltaanalytics.ftirweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingpageController {

    @RequestMapping("/")
    public String index() {
        return "landingpage";
    }
}
