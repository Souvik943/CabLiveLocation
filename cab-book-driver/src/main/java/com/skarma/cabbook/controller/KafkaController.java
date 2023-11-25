package com.skarma.cabbook.controller;
import com.skarma.cabbook.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {


        for(int i=0;i<100;i++){
            kafkaService.updateLocation("("+(Math.random()*100)+","+(Math.random()*100)+")");
            Thread.sleep(1500);
        }
        return new ResponseEntity<>(Map.of("message:","Location Updated"), HttpStatus.OK);

    }


}
