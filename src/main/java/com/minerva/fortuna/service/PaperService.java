package com.minerva.fortuna.service;

import com.minerva.fortuna.domain.Paper;
import com.minerva.fortuna.repository.PaperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService {

    private final PaperRepository repository;

    public PaperService(PaperRepository repository) {
        this.repository = repository;
    }

    public List<Paper> findAll() {
        return repository.findAll();
    }

    public Paper create(final Paper paper) {
        return repository.save(paper);
    }
}
