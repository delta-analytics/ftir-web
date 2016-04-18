package deltaanalytics.ftirweb.service;

import deltaanalytics.ftirweb.dto.BrukerParametersDto;
import deltaanalytics.ftirweb.dto.MeasureSampleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.List;

@Component
public class BrukerRestClient {
    @Autowired
    private RestOperations restTemplate;
    @Value("${bruker-service.host}")
    private String host;
    @Value("${bruker-service.port}")
    private int port;
    @Value("${bruker-service.defaultParameter.url}")
    private String defaultParameterUrl;
    @Value("${bruker-service.version.url}")
    private String versionUrl;
    @Value("${bruker-service.measureReference.url}")
    private String measureReferenceUrl;
    @Value("${bruker-service.measureReferences.url}")
    private String measureReferencesUrl;
    @Value("${bruker-service.measureSample.url}")
    private String measureSampleUrl;
    @Value("${bruker-service.measureSamples.url}")
    private String measureSamplesUrl;

    public List<MeasureSampleDto> getMeasureSamples() {
        ResponseEntity<List<MeasureSampleDto>> responseEntity = restTemplate.exchange(hostWithPort() + measureSamplesUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<MeasureSampleDto>>() {
                });
        return responseEntity.getBody();
    }

    public BrukerParametersDto getActualDefaults() {
        return restTemplate.getForObject(hostWithPort() + defaultParameterUrl, BrukerParametersDto.class);
    }

    public void setDefaults(BrukerParametersDto brukerParametersDto) {
        restTemplate.postForLocation(hostWithPort() + defaultParameterUrl, brukerParametersDto);
    }

    public String getVersion() {
        return restTemplate.getForObject(hostWithPort() + versionUrl, String.class);
    }

    public void startMeasurement() {
        restTemplate.postForLocation(hostWithPort() + measureSampleUrl, Void.class);
    }

    private String hostWithPort() {
        return host + ":" + port;
    }
}