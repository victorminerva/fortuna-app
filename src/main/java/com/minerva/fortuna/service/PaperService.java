package com.minerva.fortuna.service;

import com.minerva.fortuna.domain.Bet;
import com.minerva.fortuna.domain.BetNumberDTO;
import com.minerva.fortuna.domain.Paper;
import com.minerva.fortuna.repository.BetRepository;
import com.minerva.fortuna.repository.PaperRepository;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaperService {

    private final PaperRepository repository;
    private final BetRepository betRepository;

    public PaperService(PaperRepository repository, BetRepository betRepository) {
        this.repository = repository;
        this.betRepository = betRepository;
    }

    @Transactional
    @Cacheable("PAPERS")
    public List<Paper> findAll() {
        return repository.findAll();
    }

    @Transactional
    @CacheEvict(value = "PAPERS", allEntries=true)
    public Paper create(final Paper paper) {
        return repository.save(paper);
    }

    @CacheEvict(value = "PAPERS", allEntries=true)
    public List<Paper> patch(final List<Paper> papers) {
        return repository.saveAllAndFlush(papers);
    }

    @CacheEvict(value = "PAPERS", allEntries=true)
    public Boolean updateBetNumbers(final BetNumberDTO dto) {
        Optional<Paper> byId = repository.findById(dto.getPaperId());
        if (byId.isPresent()) {
            Paper paper = byId.get();
            paper.getBets().stream()
                    .filter(bet -> bet.getId().equals(dto.getBetId()))
                    .forEach(bet -> bet.setNumbers(dto.getNumbers()));

            repository.save(paper);
        }
        return true;
    }

    @Transactional
    @CacheEvict(value = "PAPERS", allEntries=true)
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @CacheEvict(value = "PAPERS", allEntries=true)
    public Boolean addBetNumbers(BetNumberDTO dto) {
        Optional<Paper> byId = repository.findById(dto.getPaperId());
        if (byId.isPresent()) {
            Paper paper = byId.get();
            Bet bet = new Bet();
            bet.setNumbers(dto.getNumbers());
            paper.getBets().add(bet);
            repository.save(paper);
        }
        return true;
    }

    @Transactional
    @CacheEvict(value = "PAPERS", allEntries=true)
    public void deleteBetFromPaper(Long id) {
        repository.deleteBetFromPaper(id);
        betRepository.deleteById(id);
    }

}
