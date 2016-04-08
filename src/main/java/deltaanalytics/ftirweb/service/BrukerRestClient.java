package deltaanalytics.ftirweb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class BrukerRestClient {
    private RestOperations restTemplate;
    @Value("${jueke-service.host}")
    private String host;
    @Value("${jueke-service.port}")
    private int port;

    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }
}
