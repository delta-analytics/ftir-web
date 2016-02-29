package deltaanalytics.ftirweb.controller;

import deltaanalytics.bruker.data.entity.BrukerParameters;
import deltaanalytics.bruker.data.repository.BrukerParametersRepository;
import deltaanalytics.bruker.data.repository.MeasureSampleRepository;
import deltaanalytics.bruker.hardware.CommandRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.NoResultException;

@Controller
@RequestMapping("/measurements")
public class MeasuresampleController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("allMeasurements", new MeasureSampleRepository().findAll());
        return "measurements/measurements";
    }

    @RequestMapping("/parameter")
    public String parameter(Model model) {
        BrukerParameters brukerParameters;
        try {
            brukerParameters = new BrukerParametersRepository().readCurrentActiveDefault();
        } catch (NoResultException e) {
            brukerParameters = BrukerParameters.getDefault();
        }
        model.addAttribute("brukerParameters", brukerParameters);
        return "measurements/parameter";
    }

    @RequestMapping(value = "/parameter", method = RequestMethod.POST)
    public String saveParameter(BrukerParameters brukerParameters) {
        new BrukerParametersRepository().createOrUpdateAndMakeDefault(brukerParameters);
        return "measurements/parameter";
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String start() {
        new CommandRunner().measureSample("host", 0);
        return "measurements/";
    }

}
