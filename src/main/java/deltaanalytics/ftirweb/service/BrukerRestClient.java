package deltaanalytics.ftirweb.service;

import deltaanalytics.ftirweb.dto.MutableBrukerParametersDto;
import deltaanalytics.ftirweb.dto.MeasureSampleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(BrukerRestClient.class);
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

    public MeasureSampleDto getMeasureSample(Long measureSampleId) {
        String request = hostWithPort() + measureSamplesUrl + "/" + measureSampleId;
        logger.info(request);
        return restTemplate.getForObject(request, MeasureSampleDto.class);
    }

    public MutableBrukerParametersDto getActualDefaults() {
        return restTemplate.getForObject(hostWithPort() + defaultParameterUrl, MutableBrukerParametersDto.class);
    }

    public void setDefaults(MutableBrukerParametersDto mutableBrukerParametersDto) {
        restTemplate.postForLocation(hostWithPort() + defaultParameterUrl, mutableBrukerParametersDto);
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
