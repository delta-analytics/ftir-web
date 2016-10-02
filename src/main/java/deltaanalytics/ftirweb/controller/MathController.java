package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.HitranParametersDto;
import deltaanalytics.ftirweb.dto.LevenbergMarquardtParametersDto;
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
        model.addAttribute("levenberg", mathRestClient.getLevenbergMarquardtParameters());    // FJ we get a List of LevenbergMarquardtParameters
        return "math/levenberg";
    }

    @RequestMapping(value = "/levenberg", method = RequestMethod.POST)
    public String setLevenberg(LevenbergMarquardtParametersDto levenbergMarquardtParametersDto) {
        logger.info("setLevenberg " + levenbergMarquardtParametersDto.toString());
        mathRestClient.setLevenbergMarquardtParameters(levenbergMarquardtParametersDto);     // FJ we only set one LevenbergMarquardtParameters for one molecule
        return "redirect:/math/levenberg";
    }

    @RequestMapping("/hitran")
    public String getHitran(Model model) {
        logger.info("getHitran");
        model.addAttribute("hitran", mathRestClient.getHitranParameters());
        return "math/hitran";
    }

    @RequestMapping(value = "/hitran", method = RequestMethod.POST)
    public String setHitran(HitranParametersDto hitranParametersDto) {
        logger.info("setHitran " + hitranParametersDto.toString());
        mathRestClient.setHitranParameters(hitranParametersDto);
        return "redirect:/math/hitran";
    }
}
