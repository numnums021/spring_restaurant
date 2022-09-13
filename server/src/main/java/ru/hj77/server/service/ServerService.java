package ru.hj77.server.service;

import org.springframework.stereotype.Service;
import ru.hj77.common.dto.SourceDTO;
import ru.hj77.server.db.DataBase;

@Service
public class ServerService {

    public void addOrder(SourceDTO sourceDTO){
        DataBase.insertData(sourceDTO.getId(), sourceDTO.getName());
        DataBase.print();
    }
}
