package com.minerva.fortuna;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minerva.fortuna.domain.Bet;
import com.minerva.fortuna.domain.Paper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


class FortunaApplicationTests {

    @Test
    void name() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8, 10, 11, 12, 16, 18, 19, 21, 24, 25));


        Map<Integer, Integer> jumpCounts = new HashMap<>();
        for (int i = 1; i < numbers.size(); i++) {
            int jump = Math.abs(numbers.get(i) - numbers.get(i - 1));
            if (jump > 2 && jump < 9) {
                jumpCounts.put(jump, jumpCounts.getOrDefault(jump, 0) + 1);
            }
        }
        System.out.println(jumpCounts);

//        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8, 10, 11, 12, 16, 18, 19, 21, 24, 25));
//
//        ArrayList<Integer> list0 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7, 10, 12, 13, 15, 19, 20, 22, 23, 24));
//        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8, 10, 12, 13, 16, 19, 20, 21, 23, 24));// this one
//        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7, 10, 12, 13, 15, 19, 20, 22, 23, 24));
//        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8, 10, 11, 13, 16, 18, 20, 21, 24, 25));// and this one
//
//        List<List<Integer>> allList = new ArrayList<>(List.of(list0, list1, list2, list3));
//        allList.forEach(it -> {
//            it.retainAll(winningNumbers);
//            if (it.size() > 10) {
//                System.out.println(allList.indexOf(it)+ " - " + it.size());
//            }
//        });

    }
}
