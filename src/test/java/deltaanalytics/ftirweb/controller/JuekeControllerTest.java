package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.JuekeStatusDto;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JuekeControllerTest {

    @Test
    public void getStatus() throws Exception {
        JuekeController juekeController = new JuekeController();
        String statusUrl = "http://localhost:50000/status";
        juekeController.setJuekeServiceStatusUrl(statusUrl);
        RestOperations restOperations = mock(RestOperations.class);
        juekeController.setRestOperations(restOperations);
        JuekeStatusDto juekeStatusDto = new JuekeStatusDto();
        when(restOperations.getForObject(statusUrl, JuekeStatusDto.class)).thenReturn(juekeStatusDto);

        JuekeStatusDto juekeStatusDtoHttp = juekeController.getStatus();

        assertThat(juekeStatusDtoHttp, is(equalTo(juekeStatusDto)));


    }
}