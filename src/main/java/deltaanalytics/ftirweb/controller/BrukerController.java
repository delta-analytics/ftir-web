package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.MutableBrukerParametersDto;
import deltaanalytics.ftirweb.service.BrukerRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bruker")
public class BrukerController {
    private static final Logger logger = LoggerFactory.getLogger(BrukerController.class);

    @Autowired
    private BrukerRestClient brukerRestClient;

    @RequestMapping("/")
    public String index(Model model) {
        //model.addAttribute("brukerVersion", brukerRestClient.getVersion());
        return "bruker/index";
    }

    @RequestMapping("/measurereference")
    public String measureReferences() {
        return "measurereference";
    }

    @RequestMapping("/measuresamples")
    public String measureSamples(Model model) {
        model.addAttribute("allMeasurements", brukerRestClient.getMeasureSamples());
        return "bruker/measurements";
    }

    @RequestMapping(value = "/parameter", method = RequestMethod.POST)
    public String saveParameter(MutableBrukerParametersDto brukerParameters) {
        brukerRestClient.setDefaults(brukerParameters);
        return "redirect:/bruker/parameter";
    }

    @RequestMapping("/parameter")
    public String parameter(Model model) {
        model.addAttribute("brukerParameters", brukerRestClient.getActualDefaults());
        return "bruker/parameter";
    }

    @RequestMapping(value = "/measurement/start", method = RequestMethod.POST)
    public String startMeasurement() {
        brukerRestClient.startMeasurement();
        return "redirect:/bruker/measurements";
    }
}
