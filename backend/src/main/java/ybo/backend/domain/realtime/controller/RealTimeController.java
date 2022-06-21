package ybo.backend.domain.realtime.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ybo.backend.domain.realtime.dto.TeamRankDto;
import ybo.backend.domain.test.domain.Text;
import ybo.backend.domain.test.dto.TextSaveRequestDto;
import ybo.backend.domain.test.service.TextService;
import ybo.backend.global.error.GlobalErrorResponseMessage;
import ybo.backend.global.error.exception.CustomIllegalArgumentException;
import ybo.backend.global.response.DefaultResponse;
import ybo.backend.global.response.StatusCode;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RealTimeController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${flask.server.ip}")
    private String flaskServerIp;

    @GetMapping("/realtime-ranking")
    public DefaultResponse saveText() {
        DefaultResponse response = restTemplate.getForObject("http://"+flaskServerIp+":5000"+"/rank", DefaultResponse.class);
        List<TeamRankDto> data = (List<TeamRankDto>) response.getData();
        return DefaultResponse.res(StatusCode.OK, RealTimeResponseMessage.REALTIME_RANKING_SEND_SUCCESS, data);
    }
}