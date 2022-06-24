package ybo.backend.domain.realtime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.realtime.domain.RealtimeRanking;

public interface RealtimeRankingRepository extends JpaRepository<RealtimeRanking, Long> {
}
