package com.coderefer.learnconcepts.service;

import com.coderefer.learnconcepts.entity.Album;
import feign.RequestLine;

import java.util.List;

public interface LCClient {
    @RequestLine("GET")
    List<Album> getAlbumData();
}
