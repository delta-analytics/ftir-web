package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.MutableBrukerParametersDto;
import deltaanalytics.ftirweb.service.BrukerRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/getMeasuredSamples")
    public String measuredSamples(Model model) {
        logger.info("ftir-web-service BrukerController /getMeasuredSamples");
        model.addAttribute("allMeasurements", brukerRestClient.getMeasuredSamples());
        return "bruker/measurements";
    }

    @RequestMapping("/getMeasuredSamples/{measureSampleId}")
    public String measuredSample(Model model, @PathVariable Long measureSampleId) {
        logger.info("ftir-web-service BrukerController /getMeasuredSamples + ID");
        model.addAttribute("getMeasuredSample", brukerRestClient.getMeasuredSample(measureSampleId));   // attribute used in measureSampleModal.html
        return "bruker/measureSampleModal";   // FJ measureSampleModal.html
    }

    @RequestMapping(value = "/parameter", method = RequestMethod.POST)
    public String saveParameter(MutableBrukerParametersDto brukerParameters) {
        logger.info("ftir-web-service BrukerController /parameter POST");
        brukerRestClient.setDefaults(brukerParameters);
        return "redirect:/bruker/parameter";
    }

    @RequestMapping("/parameter")
    public String parameter(Model model) {
        logger.info("ftir-web-service BrukerController /parameter GET");
        model.addAttribute("brukerParameters", brukerRestClient.getActualDefaults());  // FJ getActualDefaults() fetches getCurrentDefaultTrue from bruker-service
        return "bruker/parameter";  // FJ calls paramter.html from templates/bruker
    }

    @RequestMapping(value = "/measureSample", method = RequestMethod.POST)   // FJ same string in bruker-service !
    public String startMeasurement() {
        logger.info("ftir-web-service BrukerController /measureSample");
        brukerRestClient.startMeasurement();
        return "redirect:/bruker/measurements";  // measurements.html in templates folder
    }

    @RequestMapping(value = "/measureReference", method = RequestMethod.POST)  // FJ same string in bruker-service !
    public String startReference() {
        brukerRestClient.startReference();
        logger.info("ftir-web-service BrukerController /measureReference");
        return "redirect:/bruker/measurements";  // measurements.html in templates folder
    }
}
