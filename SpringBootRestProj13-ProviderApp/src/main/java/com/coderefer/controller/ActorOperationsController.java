package com.coderefer.controller;

import com.coderefer.entity.Actor;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actor")
@ApiOperation("For Actor greeting")
public class ActorOperationsController {
    @GetMapping("/wish/{id}/{name}")
    public ResponseEntity<String> displayWishMsg(@PathVariable Integer id, @PathVariable String name) {
        return ResponseEntity.ok("Good Morning! " + id + " - " + name);
    }
    @GetMapping("/wish")
    public ResponseEntity<String> displayWishMsg() {
        return ResponseEntity.ok("Good Morning!");
    }

    @PostMapping("/postActor")
    public ResponseEntity<String> showActor(@RequestBody Actor actor) {
        return ResponseEntity.ok("Received Actor data: " + actor.toString());
    }
}
