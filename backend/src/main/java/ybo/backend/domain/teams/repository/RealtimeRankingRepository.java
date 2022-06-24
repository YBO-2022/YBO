package ybo.backend.domain.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.teams.domain.RealtimeRanking;

public interface RealtimeRankingRepository extends JpaRepository<RealtimeRanking, Long> {
    RealtimeRanking findByTeam(String team);
}
