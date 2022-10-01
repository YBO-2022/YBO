package ybo.backend.domain.realtime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.realtime.domain.RealtimeGame;

public interface RealtimeGameRepository extends JpaRepository<RealtimeGame, Long> {
}
