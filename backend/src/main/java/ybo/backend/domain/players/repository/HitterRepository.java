package ybo.backend.domain.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.players.domain.Hitter;
import ybo.backend.domain.players.domain.Pitcher;

import java.util.List;


public interface HitterRepository extends JpaRepository<Hitter, Long>{
    // 타율순(내림)
    List<Hitter> findTop3ByOrderByBaDesc();
    // 출루율(내림)
    List<Hitter> findTop3ByOrderByObpDesc();
    // 장타율(내림)
    List<Hitter> findTop3ByOrderBySlgDesc();
    // 타점(내림)
    List<Hitter> findTop3ByOrderByRbiDesc();
    // 홈런(내림)
    List<Hitter> findTop3ByOrderByHomerunDesc();
    // 도루(내림)
    List<Hitter> findTop3ByOrderByStealDesc();
}