package com.minerva.fortuna.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "integer[]")
    private List<Integer> numbers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bet)) return false;
        Bet bet = (Bet) o;
        return Objects.equals(id, bet.id) &&
                Arrays.equals(numbers.toArray(), bet.numbers.toArray());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numbers);
    }
}
