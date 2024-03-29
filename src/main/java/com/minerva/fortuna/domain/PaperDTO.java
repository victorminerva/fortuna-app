package com.minerva.fortuna.domain;

public class PaperDTO {
    private Paper paper;
    private Integer correctGuesses;

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setCorrectGuesses(Integer correctGuesses) {
        this.correctGuesses = correctGuesses;
    }

    public Integer getCorrectGuesses() {
        return correctGuesses;
    }
}
