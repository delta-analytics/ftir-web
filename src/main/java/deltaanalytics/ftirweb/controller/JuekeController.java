package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.JuekeStatusDto;
import deltaanalytics.ftirweb.service.JuekeRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jueke")
public class JuekeController {
    private static final Logger logger = LoggerFactory.getLogger(JuekeController.class);
    private JuekeRestClient juekeRestClient;

    @RequestMapping("/")
    public String index(Model model) {
        JuekeStatusDto juekeStatusDto = new JuekeStatusDto();
        model.addAttribute("juekeStatusDto", juekeStatusDto);
        return "jueke/index";
    }

    @RequestMapping("/currentstate")
    @ResponseBody
    public JuekeStatusDto currentstate() {
        return juekeRestClient.getStatus();
    }

    @RequestMapping("/systemstate")
    public String systemstate() {
        return "jueke/systemstate";
    }

    @RequestMapping(value = "/disablePump", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity disablePump() {
        logger.info("disablePump");
        juekeRestClient.pumpDisable();
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/pump/speed/{speed}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity setPumpSpeed(@PathVariable("speed") int pumpSpeed) {
        logger.info("pump/speed/" + pumpSpeed);
        juekeRestClient.pumpSpeed(pumpSpeed);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/pressure/{pressure}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity setPressure(@PathVariable("pressure") int pressure) {
        logger.info("pressure/" + pressure);
        juekeRestClient.pressure(pressure);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/valves/{valve}/enable", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity enableValve(@PathVariable int valve) {
        logger.info("enableValve " + valve);
        juekeRestClient.enableValve(valve);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/valves/{valve}/disable", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity disableValve(@PathVariable int valve) {
        logger.info("disableValve " + valve);
        juekeRestClient.disableValve(valve);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/temperature/{temperature}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity setTemperature(@PathVariable("temperature") int temperature) {
        logger.info("temperature/" + temperature);
        juekeRestClient.temperature(temperature);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/status")
    @ResponseBody
    public JuekeStatusDto getStatus() {
        return juekeRestClient.getStatus();
    }

    @RequestMapping(value = "/pressureRegulationStart")
    @ResponseBody
    public ResponseEntity pressureRegulationStart() {
        logger.info("pressureRegulationStart");
        juekeRestClient.pressureRegulationStart();
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/pressureRegulationStop")
    @ResponseBody
    public ResponseEntity pressureRegulationStop() {
        logger.info("pressureRegulationStop");
        juekeRestClient.pressureRegulationStop();
        return new ResponseEntity(HttpStatus.OK);
    }

    @Autowired
    public void setJuekeRestClient(JuekeRestClient juekeRestClient) {
        this.juekeRestClient = juekeRestClient;
    }
}
