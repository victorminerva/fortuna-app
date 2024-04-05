package com.minerva.fortuna.repository;

import com.minerva.fortuna.domain.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaperRepository extends JpaRepository<Paper, Long> {

//    @Query("SELECT pb.numbers FROM paper_bets pb, bet_numbers bn WHERE pb.paper_id = ?1 AND bn.bet_id = ?2 AND bn.bet_id = pb.bets_id AND p.id = pb.paper_id")
//    List<Integer> findByPaperIdAndBetId(final Long paperId, final Long betId);
}
