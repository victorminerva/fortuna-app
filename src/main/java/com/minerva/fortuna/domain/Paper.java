package com.minerva.fortuna.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name = "PAPER")
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id ASC")
    private List<Bet> bets;

    @Transient
    private Integer correctGuesses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Integer getCorrectGuesses() {
        return correctGuesses;
    }

    public void setCorrectGuesses(Integer correctGuesses) {
        this.correctGuesses = correctGuesses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paper)) return false;
        Paper paper = (Paper) o;
        return Objects.equals(id, paper.id) &&
                bets.size() == paper.bets.size() &&
                bets.containsAll(paper.bets);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bets != null ? bets.hashCode() : 0);
        return result;
    }
}
