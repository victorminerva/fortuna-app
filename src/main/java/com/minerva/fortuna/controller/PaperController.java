package com.minerva.fortuna.controller;

import com.minerva.fortuna.domain.BetNumberDTO;
import com.minerva.fortuna.domain.Paper;
import com.minerva.fortuna.service.PaperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/papers")
public class PaperController {

    private final PaperService service;

    public PaperController(final PaperService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paper> getAllPapers() {
        return service.findAll();
    }

    @PostMapping
    public Paper createPaper(@RequestBody final Paper paper) {
        return service.create(paper);
    }

    @PutMapping
    public Boolean updateBetNumbers(@RequestBody final BetNumberDTO dto) {
        return service.updateBetNumbers(dto);
    }

    @DeleteMapping("/{id}")
    public String deletePaper(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/paper-list"; // Redirect to a page showing all papers
    }
}
