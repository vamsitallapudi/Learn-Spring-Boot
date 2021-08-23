package com.coderefer.learnconcepts.service;

import com.coderefer.learnconcepts.entity.Album;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LCService {
    LCClient client;

    public LCService() {
        client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(LCClient.class))
                .logLevel(Logger.Level.FULL)
                .target(LCClient.class, "https://jsonplaceholder.typicode.com/albums");
    }

    public List<Album> getAlbums() {
        return client.getAlbumData();
    }
}
