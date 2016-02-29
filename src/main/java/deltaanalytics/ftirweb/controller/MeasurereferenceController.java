package deltaanalytics.ftirweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeasurereferenceController {

    @RequestMapping("/measurereference")
    public String index() {
        return "measurereference";
    }
}
