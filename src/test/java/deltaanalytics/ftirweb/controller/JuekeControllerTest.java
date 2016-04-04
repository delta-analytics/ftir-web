package deltaanalytics.ftirweb.controller;

import deltaanalytics.ftirweb.dto.JuekeStatusDto;
import deltaanalytics.ftirweb.service.JuekeRestClient;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JuekeControllerTest {

    @Test
    public void getStatus() throws Exception {
        JuekeController juekeController = new JuekeController();
        JuekeRestClient juekeRestClient = mock(JuekeRestClient.class);
        juekeController.setJuekeRestClient(juekeRestClient);
        JuekeStatusDto juekeStatusDto = new JuekeStatusDto();
        when(juekeRestClient.getStatus()).thenReturn(juekeStatusDto);

        JuekeStatusDto juekeStatusDtoHttp = juekeController.getStatus();

        assertThat(juekeStatusDtoHttp, is(equalTo(juekeStatusDto)));
    }
}