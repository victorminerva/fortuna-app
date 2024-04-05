package com.minerva.fortuna.domain;

import java.util.List;

public class BetNumberDTO {
    private Long paperId;
    private Integer betId;
    private List<Integer> numbers;

    public BetNumberDTO() {
    }

    public BetNumberDTO(Long paperId, Integer betId, List<Integer> numbers) {
        this.paperId = paperId;
        this.betId = betId;
        this.numbers = numbers;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Integer getBetId() {
        return betId;
    }

    public void setBetId(Integer betId) {
        this.betId = betId;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
