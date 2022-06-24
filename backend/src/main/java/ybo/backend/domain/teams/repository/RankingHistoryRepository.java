package ybo.backend.domain.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.teams.domain.RankingHistory;

import java.util.List;

public interface RankingHistoryRepository extends JpaRepository<RankingHistory, Long> {
    List<RankingHistory> findByTeam(String team);
}
