package ru.hj77.server.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.hj77.common.dto.SourceDTO;
import ru.hj77.server.service.ServerService;

@AllArgsConstructor
@RestController("/")
public class ServerController {

    ServerService service;

    @PostMapping(value = "/mq")
    public ResponseEntity<String> addOrder(@RequestBody SourceDTO sourceDTO){
        service.addOrder(sourceDTO);
        return new ResponseEntity<>(
                "Заказ добавлен " + sourceDTO.getId() + " - " + sourceDTO.getName(), HttpStatus.OK);
    }
}
