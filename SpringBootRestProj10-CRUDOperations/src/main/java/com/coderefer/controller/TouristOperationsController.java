package com.coderefer.controller;

import com.coderefer.entity.Tourist;
import com.coderefer.exceptions.TouristNotFoundException;
import com.coderefer.service.ITouristMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {
    @Autowired
    private ITouristMgmtService service;

    @PostMapping("/register")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
        try {
            String resultMsg = service.registerTourist(tourist);
            return new ResponseEntity<>(resultMsg, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create tourist", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> displayTourists() {
        try {
            List<Tourist> list = service.fetchAllTourist();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>
                    ("Problem in fetching tourists",
                            HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("find/{id}")
    public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(service.findTouristById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error fetching tourist", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public String updateTourist(@RequestBody Tourist tourist) {
        try {
           return service.updateTouristDetails(tourist);
        } catch (TouristNotFoundException e ) {
            e.printStackTrace();
            return "Tourist not found";
        }
    }

}
