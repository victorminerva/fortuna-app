package com.minerva.fortuna.controller;

import com.minerva.fortuna.domain.Paper;
import com.minerva.fortuna.service.MainService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public List<Paper> analyze(@RequestBody final List<Integer> winningNumbers) {
        return service.analyze(winningNumbers);
    }

}
