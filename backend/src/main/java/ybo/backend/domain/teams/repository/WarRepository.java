package ybo.backend.domain.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ybo.backend.domain.teams.domain.War;
import java.util.List;

public interface WarRepository extends JpaRepository<War, Long> {
    @Query(value = "select * from War w where w.team = :team order by war desc limit 0, 5", nativeQuery = true)
    List<War> findTop5War(@Param("team") String team);

    @Query(value = "select * from War w where w.team = :team order by war asc limit 0, 5", nativeQuery = true)
    List<War> findLow5War(@Param("team") String team);
}
