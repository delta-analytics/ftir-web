package deltaanalytics.ftirweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {

    @RequestMapping("/reports")
    public String index() {
        return "reports";
    }
}
