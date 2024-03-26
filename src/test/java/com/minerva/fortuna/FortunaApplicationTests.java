package com.minerva.fortuna;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minerva.fortuna.domain.Bet;
import com.minerva.fortuna.domain.Paper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class FortunaApplicationTests {

    @Test
    void name() {
        Paper paper = new Paper();
        List<Bet> bets = new ArrayList<>();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Bet bet = new Bet();
        bet.setNumbers(numbers);
        bets.add(bet);
        paper.setBets(bets);
        try {
            String json = new ObjectMapper().writeValueAsString(paper);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
