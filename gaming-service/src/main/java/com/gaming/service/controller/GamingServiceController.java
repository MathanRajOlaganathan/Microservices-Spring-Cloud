package com.gaming.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 20/12/2020
 */
@RestController
@RequestMapping("/games")
public class GamingServiceController {

    @GetMapping
    public List<String> getGames(){
        return Stream.of("CS GO","NFS","God of War","Prince of Persia","WWE 2K20","CRIC 07")
                .collect(Collectors.toList());
    }
}
