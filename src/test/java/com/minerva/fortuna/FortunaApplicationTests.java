package com.minerva.fortuna;

import org.junit.jupiter.api.Test;

import java.util.*;


class FortunaApplicationTests {

    @Test
    void name() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 9, 10, 12, 13, 14, 15, 17, 18, 24, 25));

//        Map<Integer, Integer> jumpCounts = new HashMap<>();
//        for (int i = 1; i < numbers.size(); i++) {
//            int jump = Math.abs(numbers.get(i) - numbers.get(i - 1));
//            if (jump > 2 && jump < 9) {
//                jumpCounts.put(jump, jumpCounts.getOrDefault(jump, 0) + 1);
//            }
//        }
//
//        Map<Integer, Integer> reversedJumpCounts = new HashMap<>();
//        for (Map.Entry<Integer, Integer> entry : jumpCounts.entrySet()) {
//            reversedJumpCounts.put(entry.getValue(), entry.getKey());
//        }
        //01 - 02 - 03 - 04 - 05 - 08 - 10 - 11 - 12 - 16 - 18 - 19 - 21 - 24 - 25
        //TODO: Dr Audizio
        //01 - 03 - 04 - 05 - 07 - 08 - 09 - 10 - 11 - 17 - 19 - 21 - 22 - 24 - 25
        //01 - 02 - 03 - 04 - 08 - 09 - 10 - 12 - 13 - 14 - 15 - 17 - 18 - 24 - 25
        //02 - 03 - 06 - 08 - 09 - 12 - 13 - 16 - 17 - 18 - 19 - 20 - 21 - 22 - 24

//        System.out.println(reversedJumpCounts);

        int[] counts = new int[3]; // Array to store counts for each group

        for (int number : numbers) {
            if (number >= 1 && number <= 8) {
                counts[0]++; // Increment count for group 1-8
            } else if (number >= 9 && number <= 17) {
                counts[1]++; // Increment count for group 9-17
            } else if (number >= 18 && number <= 25) {
                counts[2]++; // Increment count for group 18-25
            }
        }

        System.out.println("Result: " + Arrays.toString(counts));
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
