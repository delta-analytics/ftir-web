package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.BrukerParametersDto;
import deltaanalytics.ftirweb.service.BrukerRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.NoResultException;

@Controller
@RequestMapping("/bruker")
public class BrukerController {
    private static final Logger logger = LoggerFactory.getLogger(BrukerController.class);

    @Autowired
    private BrukerRestClient brukerRestClient;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("brukerVersion", brukerRestClient.getVersion());
        return "bruker/index";
    }
    @RequestMapping("/measurereference")
    public String measureReferences() {
        return "measurereference";
    }

    @RequestMapping("/measuresamples")
    public String measureSamples(Model model) {
        //model.addAttribute("allMeasurements", brukerRestClient.getMeasureSamples());
        return "bruker/measurements";
    }

    @RequestMapping(value = "/parameter", method = RequestMethod.POST)
    public String saveParameter(BrukerParametersDto brukerParameters) {
        brukerRestClient.setDefaults(brukerParameters);
        return "bruker/parameter";
    }

    @RequestMapping("/parameter")
    public String parameter(Model model) {
        BrukerParametersDto brukerParameters = null;
        try {
            brukerParameters = brukerRestClient.getActualDefaults();
        } catch (NoResultException e) {
            brukerParameters = BrukerParametersDto.getDefault();
            logger.error("", e);
        }
        model.addAttribute("brukerParameters", brukerParameters);
        return "bruker/parameter";
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String startMeasurement() {
        brukerRestClient.startMeasurement();
        return "bruker/";
    }
}
