package com.coderefer.LearnSpringBoot01.controller.user;

import com.coderefer.LearnSpringBoot01.entity.User;
import com.coderefer.LearnSpringBoot01.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveUsers());
        EntityModel<User> model = EntityModel.of(service.findOne(id));
        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    @PostMapping("/users/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User newUser = service.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
}
