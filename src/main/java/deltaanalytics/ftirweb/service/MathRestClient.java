package deltaanalytics.ftirweb.service;

import deltaanalytics.ftirweb.dto.HitranParameters;
import deltaanalytics.ftirweb.dto.LevenbergMarquardtParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class MathRestClient {
    @Autowired
    private RestOperations restTemplate;
    @Value("${math-service.host}")
    private String host;
    @Value("${math-service.port}")
    private int port;
    @Value("${math-service.levenberg.url}")
    private String levenbergUrl;
    @Value("${math-service.hitran.url}")
    private String hitranUrl;

    public LevenbergMarquardtParameters getLevenbergMarquardtParameters() {
        return restTemplate.getForObject(hostWithPort() + levenbergUrl, LevenbergMarquardtParameters.class);
    }

    public HitranParameters getHitranParameters() {
        return restTemplate.getForObject(hostWithPort() + hitranUrl, HitranParameters.class);
    }

    private String hostWithPort() {
        return host + ":" + port;
    }
}
