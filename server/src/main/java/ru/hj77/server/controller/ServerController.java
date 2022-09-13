package ru.hj77.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.hj77.common.dto.SourceDTO;
import ru.hj77.server.db.DataBase;

@RestController("/")
public class ServerController {

    @PostMapping(value = "/mq")
    public ResponseEntity<String> getClient(@RequestBody SourceDTO sourceDTO){
        DataBase.insertData(sourceDTO.getId(), sourceDTO.getName());
        DataBase.print();
        return new ResponseEntity<>(
                "Заказ добавлен " + sourceDTO.getId() + " - " + sourceDTO.getName(), HttpStatus.OK);
    }
}
