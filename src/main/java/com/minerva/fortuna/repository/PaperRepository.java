package com.minerva.fortuna.repository;

import com.minerva.fortuna.domain.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PaperRepository extends JpaRepository<Paper, Long> {

    @Modifying
    @Query(value = "DELETE FROM paper_bets WHERE bets_id = ?", nativeQuery = true)
    void deleteBetFromPaper(Long betId);


}
