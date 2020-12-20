package com.gaming.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 20/12/2020
 */
@RestController
public class GamingController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/games")
    public String[] getGames(){
       return restTemplate.getForObject("http://GAMING-SERVICE/games",
               String[].class);

    }
}
