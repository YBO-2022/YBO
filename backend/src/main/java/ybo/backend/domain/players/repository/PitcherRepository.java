package ybo.backend.domain.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.players.domain.Pitcher;

import java.util.List;


public interface PitcherRepository extends JpaRepository<Pitcher, Long> {

    // 다승(내림)
    List<Pitcher> findTop3ByOrderByWinDesc();
    // 방어율(오름)
    List<Pitcher> findTop3ByOrderByEraAsc();
    // 자책(오름)
    List<Pitcher> findTop3ByOrderByEarnedRunAsc();
    // 세이브(내림)
    List<Pitcher> findTop3ByOrderBySaveDesc();
    // 홀드(내림)
    List<Pitcher> findTop3ByOrderByHoldDesc();
    // 삼진(내림)
    List<Pitcher> findTop3ByOrderByStrikeoutDesc();
}
