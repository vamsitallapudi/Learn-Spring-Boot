package com.coderefer.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
@ApiOperation("For Actor greeting")
public class ActorOperationsController {
    @GetMapping
    public ResponseEntity<String> displayWishMsg() {
        return ResponseEntity.ok("Good Morning!");
    }
}
