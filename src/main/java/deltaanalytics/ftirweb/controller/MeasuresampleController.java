package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.BrukerParametersDto;
import deltaanalytics.ftirweb.dto.MeasureSampleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.persistence.NoResultException;
import java.util.List;

@Controller
@RequestMapping("/measurements")
public class MeasuresampleController {
    private static final Logger logger = LoggerFactory.getLogger(JuekeController.class);
    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/")
    public String index(Model model) {
        ResponseEntity<List<MeasureSampleDto>> rateResponse =
                restTemplate.exchange("https://bitpay.com/api/rates",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<MeasureSampleDto>>() {
                        });
        List<MeasureSampleDto> allMeasurements = rateResponse.getBody();
        model.addAttribute("allMeasurements", allMeasurements);
        return "measurements/measurements";
    }

    @RequestMapping("/parameter")
    public String parameter(Model model) {
        BrukerParametersDto brukerParameters = null;
        try {
            brukerParameters = restTemplate.getForObject("http://localhost:50000/defaultParameter", BrukerParametersDto.class);
        } catch (NoResultException e) {
            brukerParameters = BrukerParametersDto.getDefault();
            logger.error("", e);
        }
        model.addAttribute("brukerParameters", brukerParameters);
        return "measurements/parameter";
    }

    @RequestMapping(value = "/parameter", method = RequestMethod.POST)
    public String saveParameter(BrukerParametersDto brukerParameters) {
        restTemplate.postForLocation("http://localhost:50000/defaultParameter", brukerParameters);
        return "measurements/parameter";
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String start() {
        restTemplate.postForLocation("http://localhost:50000/measureSample", Void.class);
        return "measurements/";
    }

}
