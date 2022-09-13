package ru.hj77.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hj77.client.service.Service;
import ru.hj77.common.dto.SourceDTO;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class RestaurantController {

    private Service service;

    @PostMapping(value = "/mq")
    public String sendToServer(@RequestBody SourceDTO sourceDTO) {
        return service.sendToServer(sourceDTO);
    }

}
