package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.HitranParametersDto;
import deltaanalytics.ftirweb.dto.LevenbergMarquardtParametersDto;
import deltaanalytics.ftirweb.service.MathRestClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class MathControllerTest {
    private MathController mathController;
    private MathRestClient mathRestClient;

    @Before
    public void setup() {
        mathController = new MathController();
        mathRestClient = mock(MathRestClient.class);
        ReflectionTestUtils.setField(mathController, "mathRestClient", mathRestClient);
    }

    @Test
    public void getLevenberg() throws Exception {
        Model model = mock(Model.class);
        List <LevenbergMarquardtParametersDto> levenbergMarquardtParametersDto = new ArrayList<>();
        when(mathRestClient.getLevenbergMarquardtParameters()).thenReturn(levenbergMarquardtParametersDto);

        String templatePath = mathController.getLevenberg(model);

        assertThat(templatePath, is(equalTo("math/levenberg")));
        verify(model).addAttribute("levenberg", levenbergMarquardtParametersDto);
    }

    @Test
    public void setLevenberg() throws Exception {
        LevenbergMarquardtParametersDto levenbergMarquardtParametersDto = new LevenbergMarquardtParametersDto();

        String templatePath = mathController.setLevenberg(levenbergMarquardtParametersDto);

        assertThat(templatePath, is(equalTo("redirect:/math/levenberg")));
        verify(mathRestClient).setLevenbergMarquardtParameters(levenbergMarquardtParametersDto);
    }

    @Test
    public void getHitran() throws Exception {
        Model model = mock(Model.class);
        List <HitranParametersDto> hitranParametersDto = new ArrayList<>();
        when(mathRestClient.getHitranParameters()).thenReturn(hitranParametersDto);

        String templatePath = mathController.getHitran(model);

        assertThat(templatePath, is(equalTo("math/hitran")));
        verify(model).addAttribute("hitran", hitranParametersDto);
    }

    @Test
    public void setHitran() throws Exception {
        HitranParametersDto hitranParametersDto = new HitranParametersDto();

        String templatePath = mathController.setHitran(hitranParametersDto);

        assertThat(templatePath, is(equalTo("redirect:/math/hitran")));
        verify(mathRestClient).setHitranParameters(hitranParametersDto);
    }
}
