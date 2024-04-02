package com.minerva.fortuna.service;

import com.minerva.fortuna.domain.Bet;
import com.minerva.fortuna.domain.Paper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MainService {

    private final PaperService paperService;

    public MainService(PaperService paperService) {
        this.paperService = paperService;
    }

    public List<Paper> analyze(List<Integer> winningNumbers) {
        return paperService.findAll().stream()
                .flatMap(paper -> paper.getBets().stream()
                        .filter(bet -> bet.getNumbers().stream()
                                .filter(winningNumbers::contains)
                                .count() > 10)
                        .map(bet -> {
                            Paper result = new Paper();
                            result.setId(paper.getId());
                            result.setBets(List.of(bet));
                            result.setCorrectGuesses((int) bet.getNumbers().stream()
                                    .filter(winningNumbers::contains)
                                    .count());
                            return result;
                        }))
                .collect(Collectors.toList());
    }

    public Map<Integer, Integer> analyzeJumps(List<Integer> winningNumbers) {
        Map<Integer, Integer> jumpCounts = new HashMap<>();
        for (int i = 1; i < winningNumbers.size(); i++) {
            int jump = Math.abs(winningNumbers.get(i) - winningNumbers.get(i - 1));
            if (jump > 2 && jump < 9) {
                jumpCounts.put(jump, jumpCounts.getOrDefault(jump, 0) + 1);
            }
        }
        return jumpCounts;
    }
}
