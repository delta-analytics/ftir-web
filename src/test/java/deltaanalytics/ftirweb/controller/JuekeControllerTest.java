package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.JuekeStatusDto;
import deltaanalytics.ftirweb.service.JuekeRestClient;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class JuekeControllerTest {
    private JuekeController juekeController;
    private JuekeRestClient juekeRestClient;

    @Before
    public void setup() {
        juekeController = new JuekeController();
        juekeRestClient = mock(JuekeRestClient.class);
        juekeController.setJuekeRestClient(juekeRestClient);
    }

    @Test
    public void getStatus() throws Exception {
        JuekeStatusDto juekeStatusDto = new JuekeStatusDto();
        when(juekeRestClient.getStatus()).thenReturn(juekeStatusDto);

        JuekeStatusDto juekeStatusDtoHttp = juekeController.getStatus();

        assertThat(juekeStatusDtoHttp, is(equalTo(juekeStatusDto)));
    }

    @Test
    public void pumpDisable() {
        juekeController.disablePump();

        verify(juekeRestClient).pumpDisable();
    }

    @Test
    public void setPumpSpeed() {
        int pumpSpeed = 10;
        juekeController.setPumpSpeed(pumpSpeed);

        verify(juekeRestClient).pumpSpeed(pumpSpeed);
    }

    @Test
    public void setPressure() {
        int pressure = 10;
        juekeController.setPressure(pressure);

        verify(juekeRestClient).pressure(pressure);
    }

    @Test
    public void setTemperature() {
        int temperature = 10;
        juekeController.setTemperature(temperature);

        verify(juekeRestClient).temperature(temperature);
    }

    @Test
    public void pressureRegulationStart() {
        juekeController.pressureRegulationStart();

        verify(juekeRestClient).pressureRegulationStart();
    }

    @Test
    public void pressureRegulationStop() {
        juekeController.pressureRegulationStop();

        verify(juekeRestClient).pressureRegulationStop();
    }

    @Test
    public void currentstate() {
        juekeController.currentstate();

        verify(juekeRestClient).getStatus();
    }

}