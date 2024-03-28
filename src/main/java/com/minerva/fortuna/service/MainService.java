package com.minerva.fortuna.service;

import com.minerva.fortuna.domain.Bet;
import com.minerva.fortuna.domain.Paper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MainService {

    private final PaperService paperService;

    public MainService(PaperService paperService) {
        this.paperService = paperService;
    }

    public List<Paper> analyze(List<Integer> winningNumbers) {
        List<Paper> allPapers = paperService.findAll();
        List<Paper> papers = new ArrayList<>();

        for (Paper paper : allPapers) {
            List<Bet> bets = paper.getBets();
            for (Bet bet : bets) {
                List<Integer> intersection = new ArrayList<>(bet.getNumbers());
                intersection.retainAll(winningNumbers);
                if (intersection.size() > 10) {
                    papers.add(paper);
                }
            }
        }
        return papers;

//        return allPapers.stream()
//                .filter(paper -> paper.getBets().stream()
//                        .anyMatch(bet -> {
//                            Set<Integer> betNumbersSet = new HashSet<>(bet.getNumbers()); // Convert bet numbers to a set
//                            betNumbersSet.retainAll(winningNumbers); // Use retainAll on sets
//                            return betNumbersSet.size() > 10; // Check if the intersection size is greater than 10
//                        }))
//                .collect(Collectors.toList());
    }
}
