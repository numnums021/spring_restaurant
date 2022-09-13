package ru.hj77.client.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.hj77.common.dto.SourceDTO;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    private RestTemplate restTemplate;

    public String sendToServer(SourceDTO sourceDTO) {
        HttpEntity<SourceDTO> request = new HttpEntity<>(sourceDTO);
        return restTemplate.postForObject("http://localhost:1704/mq", request, String.class);
    }

}
