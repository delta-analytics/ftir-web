package deltaanalytics.ftirweb.service;

import deltaanalytics.ftirweb.dto.JuekeStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class JuekeRestClient {
    private RestOperations restTemplate;
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

    public JuekeStatusDto getStatus() {
        return restTemplate.getForObject(hostWithPort() + statusUrl, JuekeStatusDto.class);
    }

    public void pumpDisable() {
        restTemplate.postForLocation(hostWithPort() + pumpDisableUrl, null);
    }

    public void pumpSpeed(int speed) {
        restTemplate.postForLocation(hostWithPort() + pumpSpeedUrl + "/" + speed, null);
    }

    public void temperature(int temperature) {
        restTemplate.postForLocation(hostWithPort() + temperatureUrl + "/" + temperature, null);
    }

    public void pressureRegulationStart() {
        restTemplate.postForLocation(hostWithPort() + pressureRegulationStartUrl, null);
    }

    public void pressureRegulationStop() {
        restTemplate.postForLocation(hostWithPort() + pressuereRegulationStopUrl, null);
    }

    public void pressure(int pressure) {
        restTemplate.postForLocation(hostWithPort() + pressureUrl + "/" + pressure, null);
    }

    public void enableValve(int valve) {
        restTemplate.postForLocation(hostWithPort() + valvesUrl + valve + "?state=enable", null);
    }

    public void disableValve(int valve) {
        restTemplate.postForLocation(hostWithPort() + valvesUrl + valve + "?state=disable", null);
    }

    @Autowired
    public void setRestOperations(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String hostWithPort() {
        return host + ":" + port;
    }
}
