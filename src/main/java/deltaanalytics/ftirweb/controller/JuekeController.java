package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.JuekeParameterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jueke")
public class JuekeController {
    private static final Logger logger = LoggerFactory.getLogger(JuekeController.class);

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
}
