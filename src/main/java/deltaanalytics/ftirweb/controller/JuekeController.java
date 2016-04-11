package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.JuekeStatusDto;
import deltaanalytics.ftirweb.service.JuekeRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getParameter(Model model) {
        JuekeStatusDto juekeStatusDto = new JuekeStatusDto();
        model.addAttribute("juekeStatusDto", juekeStatusDto);
        return "jueke/index";
    }

    @RequestMapping(value = "/disablePump", method = RequestMethod.POST)
    public String disablePump() {
        logger.info("disablePump");
        juekeRestClient.pumpDisable();
        return "jueke/index";
    }

    @RequestMapping(value = "/pump/speed/{speed}", method = RequestMethod.POST)
    public String setPumpSpeed(@PathVariable("speed") int pumpSpeed) {
        logger.info("pump/speed/" + pumpSpeed);
        juekeRestClient.pumpSpeed(pumpSpeed);
        return "jueke/index";
    }

    @RequestMapping(value = "/pressure/{pressure}", method = RequestMethod.POST)
    public String setPressure(@PathVariable("pressure") int pressure) {
        logger.info("pressure/" + pressure);
        juekeRestClient.pressure(pressure);
        return "jueke/index";
    }

    @RequestMapping(value = "/valves/{valve}/enable", method = RequestMethod.POST)
    public String enableValve(@PathVariable int valve) {
        logger.info("enableValve " + valve);
        juekeRestClient.enableValve(valve);
        return "jueke/index";
    }

    @RequestMapping(value = "/valves/{valve}/disable", method = RequestMethod.POST)
    public String disableValve(@PathVariable int valve) {
        logger.info("disableValve " + valve);
        juekeRestClient.disableValve(valve);
        return "jueke/index";
    }

    @RequestMapping(value = "/temperature/{temperature}", method = RequestMethod.POST)
    public String setTemperature(@PathVariable("temperature") int temperature) {
        logger.info("temperature/" + temperature);
        juekeRestClient.temperature(temperature);
        return "jueke/index";
    }

    @RequestMapping(value = "/status")
    @ResponseBody
    public JuekeStatusDto getStatus() {
        return juekeRestClient.getStatus();
    }

    @RequestMapping(value = "/pressureRegulationStart")
    @ResponseBody
    public void pressureRegulationStart() {
        logger.info("pressureRegulationStart");
        juekeRestClient.pressureRegulationStart();
    }

    @RequestMapping(value = "/pressureRegulationStop")
    @ResponseBody
    public void pressureRegulationStop() {
        logger.info("pressureRegulationStop");
        juekeRestClient.pressureRegulationStop();
    }

    @Autowired
    public void setJuekeRestClient(JuekeRestClient juekeRestClient) {
        this.juekeRestClient = juekeRestClient;
    }
}
