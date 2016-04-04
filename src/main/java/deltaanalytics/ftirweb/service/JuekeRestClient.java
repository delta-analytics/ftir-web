package deltaanalytics.ftirweb.service;

import deltaanalytics.ftirweb.dto.JuekeStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class JuekeRestClient {
    private RestOperations restTemplate;
    private String host;
    private int port;
    private String statusUrl;
    private String pumpDisableUrl;
    private String pumpSpeedUrl;
    private String temperatureSpeedUrl;
    private String pressureRegulationStartUrl;
    private String pressuereRegulationStopUrl;
    private String pressureUrl;
    private String valvesUrl;

    public JuekeStatusDto getStatus() {
        return restTemplate.getForObject(hostWithPort() + statusUrl, JuekeStatusDto.class);
    }

    @Value("${jueke-service.host}")
    public void setHost(String host) {
        this.host = host;
    }

    @Value("${jueke-service.port}")
    public void setPort(int port) {
        this.port = port;
    }

    @Value("${jueke-service.status.url}")
    public void setStatusUrl(String statusUrl) {
        this.statusUrl = statusUrl;
    }

    @Value("${jueke-service.pump.disable.url}")
    public void setPumpDisableUrl(String pumpDisableUrl) {
        this.pumpDisableUrl = pumpDisableUrl;
    }

    @Value("${jueke-service.pump.speed.url}")
    public void setPumpSpeedUrl(String pumpSpeedUrl) {
        this.pumpSpeedUrl = pumpSpeedUrl;
    }

    @Value("${jueke-service.temperature.speed.url}")
    public void setTemperatureSpeedUrl(String temperatureSpeedUrl) {
        this.temperatureSpeedUrl = temperatureSpeedUrl;
    }

    @Value("${jueke-service.pressure.regulation.start.url}")
    public void setPressureRegulationStartUrl(String pressureRegulationStartUrl) {
        this.pressureRegulationStartUrl = pressureRegulationStartUrl;
    }

    @Value("${jueke-service.pressure.regulation.stop.url}")
    public void setPressuereRegulationStopUrl(String pressuereRegulationStopUrl) {
        this.pressuereRegulationStopUrl = pressuereRegulationStopUrl;
    }

    @Value("${jueke-service.pressure.url}")
    public void setPressureUrl(String pressureUrl) {
        this.pressureUrl = pressureUrl;
    }

    @Value("${jueke-service.valves.url}")
    public void setValvesUrl(String valvesUrl) {
        this.valvesUrl = valvesUrl;
    }

    @Autowired
    public void setRestOperations(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String hostWithPort() {
        return "http://" + host + ":" + port;
    }
}
