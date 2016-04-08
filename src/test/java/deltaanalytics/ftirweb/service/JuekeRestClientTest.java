package deltaanalytics.ftirweb.service;

import deltaanalytics.FtirWebGuiApplication;
import deltaanalytics.ftirweb.dto.JuekeStatusDto;
import deltaanalytics.ftirweb.dto.JuekeValvesDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestOperations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FtirWebGuiApplication.class)
public class JuekeRestClientTest {
    private RestOperations restOperations;

    @Value("${jueke-service.host}")
    private String host;
    @Value("${jueke-service.port}")
    private int port;
    @Value("${jueke-service.status.url}")
    private String statusUrl;
    @Value("${jueke-service.pump.disable.url}")
    private String pumpDisableUrl;
    @Value("${jueke-service.pump.speed.url}")
    private String pumpSpeedUrl;
    @Value("${jueke-service.temperature.url}")
    private String temperatureUrl;
    @Value("${jueke-service.pressure.regulation.start.url}")
    private String pressureRegulationStartUrl;
    @Value("${jueke-service.pressure.regulation.stop.url}")
    private String pressuereRegulationStopUrl;
    @Value("${jueke-service.pressure.url}")
    private String pressureUrl;
    @Value("${jueke-service.valves.url}")
    private String valvesUrl;

    @Autowired
    private JuekeRestClient juekeRestClient;

    @Before
    public void setup() {
        restOperations = mock(RestOperations.class);
        juekeRestClient.setRestOperations(restOperations);
    }

    @Test
    public void getStatus() throws Exception {
        juekeRestClient.getStatus();

        verify(restOperations).getForObject(buildCompleteUrl(statusUrl), JuekeStatusDto.class);
    }

    @Test
    public void pumpDisable() throws Exception {
        juekeRestClient.pumpDisable();

        verify(restOperations).postForLocation(buildCompleteUrl(pumpDisableUrl), null);
    }

    @Test
    public void pumpSpeed() throws Exception {
        int speed = 10;
        juekeRestClient.pumpSpeed(speed);

        verify(restOperations).postForLocation(buildCompleteUrl(pumpSpeedUrl + "/" + speed), null);
    }

    @Test
    public void temperature() throws Exception {
        int temperature = 10;
        juekeRestClient.temperature(temperature);

        verify(restOperations).postForLocation(buildCompleteUrl(temperatureUrl + "/" + temperature), null);
    }

    @Test
    public void pressureRegulationStart() throws Exception {
        juekeRestClient.pressureRegulationStart();

        verify(restOperations).postForLocation(buildCompleteUrl(pressureRegulationStartUrl), null);
    }

    @Test
    public void pressureRegulationStop() throws Exception {
        juekeRestClient.pressureRegulationStop();

        verify(restOperations).postForLocation(buildCompleteUrl(pressuereRegulationStopUrl), null);
    }

    @Test
    public void pressure() throws Exception {
        int pressure = 10;
        juekeRestClient.pressure(pressure);

        verify(restOperations).postForLocation(buildCompleteUrl(pressureUrl + "/" + pressure), null);
    }

    @Test
    public void valves() throws Exception {
        JuekeValvesDto juekeValvesDto = new JuekeValvesDto();
        juekeRestClient.valves(juekeValvesDto);

        verify(restOperations).postForLocation(buildCompleteUrl(valvesUrl), juekeValvesDto);
    }

    private String buildCompleteUrl(String actionUrl) {
        return host + ":" + port + actionUrl;
    }

}