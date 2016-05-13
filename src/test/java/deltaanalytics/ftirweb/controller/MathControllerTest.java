package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.HitranParameters;
import deltaanalytics.ftirweb.dto.LevenbergMarquardtParameters;
import deltaanalytics.ftirweb.service.MathRestClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;

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
        LevenbergMarquardtParameters levenbergMarquardtParameters = new LevenbergMarquardtParameters();
        when(mathRestClient.getLevenbergMarquardtParameters()).thenReturn(levenbergMarquardtParameters);

        String templatePath = mathController.getLevenberg(model);

        assertThat(templatePath, is(equalTo("math/levenberg")));
        verify(model).addAttribute("levenberg", levenbergMarquardtParameters);
    }

    @Test
    public void getHitran() throws Exception {
        Model model = mock(Model.class);
        HitranParameters hitranParameters = new HitranParameters();
        when(mathRestClient.getHitranParameters()).thenReturn(hitranParameters);

        String templatePath = mathController.getHitran(model);

        assertThat(templatePath, is(equalTo("math/hitran")));
        verify(model).addAttribute("hitran", hitranParameters);
    }
}
