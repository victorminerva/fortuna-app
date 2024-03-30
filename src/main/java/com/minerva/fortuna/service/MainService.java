package com.minerva.fortuna.service;

import com.minerva.fortuna.domain.Bet;
import com.minerva.fortuna.domain.Paper;
import org.springframework.stereotype.Service;

import java.util.*;

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
                    Paper result = new Paper();
                    result.setId(paper.getId());
                    result.setBets(new ArrayList<>());
                    result.setCorrectGuesses(intersection.size());
                    result.getBets().add(bet);
                    papers.add(result);
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
