package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.HitranParameters;
import deltaanalytics.ftirweb.dto.LevenbergMarquardtParameters;
import deltaanalytics.ftirweb.service.MathRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/math")
public class MathController {
    private static final Logger logger = LoggerFactory.getLogger(MathController.class);
    @Autowired
    private MathRestClient mathRestClient;

    @RequestMapping("/")
    public String getIndex() {
        return "math/index";
    }

    @RequestMapping("/levenberg")
    public String getLevenberg(Model model) {
        logger.info("getLevenberg");
        model.addAttribute("levenberg", mathRestClient.getLevenbergMarquardtParameters());
        return "math/levenberg";
    }

    @RequestMapping(value = "/levenberg", method = RequestMethod.POST)
    public String setLevenberg(LevenbergMarquardtParameters levenbergMarquardtParameters) {
        logger.info("setLevenberg " + levenbergMarquardtParameters.toString());
        mathRestClient.setLevenbergMarquardtParameters(levenbergMarquardtParameters);
        return "redirect:/math/levenberg";
    }

    @RequestMapping("/hitran")
    public String getHitran(Model model) {
        logger.info("getHitran");
        model.addAttribute("hitran", mathRestClient.getHitranParameters());
        return "math/hitran";
    }

    @RequestMapping(value = "/hitran", method = RequestMethod.POST)
    public String setHitran(HitranParameters hitranParameters) {
        logger.info("setHitran " + hitranParameters.toString());
        mathRestClient.setHitranParameters(hitranParameters);
        return "redirect:/math/hitran";
    }
}
