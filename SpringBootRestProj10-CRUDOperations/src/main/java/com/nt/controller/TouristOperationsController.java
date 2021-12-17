package com.nt.controller;

import com.nt.entity.Tourist;
import com.nt.service.ITouristMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TouristOperationsController {
    @Autowired
    private ITouristMgmtService service;

    @PostMapping("/register")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
        try {
            String resultMsg = service.registerTourist(tourist);
            return new ResponseEntity<>(resultMsg, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Failed to create tourist", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
