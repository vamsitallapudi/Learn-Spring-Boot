package com.coderefer.learnconcepts.controller;

import com.coderefer.learnconcepts.entity.Album;
import com.coderefer.learnconcepts.service.IMyService;
import com.coderefer.learnconcepts.service.LCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    LCService service;

    @Autowired
    List<IMyService> list;

    @GetMapping(value = "/test")
    public List<Album> myApi() {
        List<Album> albums = service.getAlbums();
        return albums;
    }
}
