package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.JuekeParameterDto;
import deltaanalytics.ftirweb.dto.JuekeStatusDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/jueke")
public class JuekeController {
    private static final Logger logger = LoggerFactory.getLogger(JuekeController.class);
    private RestOperations restTemplate;
    private String juekeServiceStatusUrl;

    @RequestMapping("/")
    public String getParameter(Model model) {
        JuekeParameterDto juekeParameterDto = new JuekeParameterDto();
        model.addAttribute("juekeParameterDto", juekeParameterDto);
        return "jueke/index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String setParameter(JuekeParameterDto juekeParameterDto) {
        logger.info(juekeParameterDto.toString());
        return "redirect:/jueke/";
    }

    @RequestMapping(value = "/disablePump", method = RequestMethod.POST)
    public String disablePump() {
        logger.info("disablePump");
        return "redirect:/";
    }

    @RequestMapping(value = "/status")
    @ResponseBody
    public JuekeStatusDto getStatus() {
        return restTemplate.getForObject(juekeServiceStatusUrl, JuekeStatusDto.class);
    }

    @Autowired
    public void setRestOperations(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${jueke-service.status.url}")
    public void setJuekeServiceStatusUrl(String juekeServiceStatusUrl) {
        this.juekeServiceStatusUrl = juekeServiceStatusUrl;
    }
}
