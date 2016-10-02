package deltaanalytics.ftirweb.service;

import deltaanalytics.ftirweb.dto.HitranParametersDto;
import deltaanalytics.ftirweb.dto.LevenbergMarquardtParametersDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    public List <LevenbergMarquardtParametersDto> getLevenbergMarquardtParameters() {
        ResponseEntity<List<LevenbergMarquardtParametersDto>> responseEntity = restTemplate.exchange(hostWithPort() + levenbergUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<LevenbergMarquardtParametersDto>>() {
                });
        return responseEntity.getBody();
    }

    public List <HitranParametersDto> getHitranParameters() {
        ResponseEntity<List<HitranParametersDto>> responseEntity = restTemplate.exchange(hostWithPort() + hitranUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<HitranParametersDto>>() {
                });
        return responseEntity.getBody();
    }

    private String hostWithPort() {
        return host + ":" + port;
    }

    public void setLevenbergMarquardtParameters(LevenbergMarquardtParametersDto levenbergMarquardtParametersDto) {
        restTemplate.postForLocation(hostWithPort() + levenbergUrl, levenbergMarquardtParametersDto);
    }

    public void setHitranParameters(HitranParametersDto hitranParametersDto) {
        restTemplate.postForLocation(hostWithPort() + hitranUrl, hitranParametersDto);
    }
}
