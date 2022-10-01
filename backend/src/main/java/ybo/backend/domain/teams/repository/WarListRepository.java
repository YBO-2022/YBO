package ybo.backend.domain.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ybo.backend.domain.teams.domain.WarList;
import java.util.List;

public interface WarListRepository extends JpaRepository<WarList, Long> {
    @Query(value = "select * from war_list w where w.team = :team order by war desc limit 0, 5", nativeQuery = true)
    List<WarList> findTop5War(@Param("team") String team);

    @Query(value = "select * from war_list w where w.team = :team order by war asc limit 0, 5", nativeQuery = true)
    List<WarList> findLow5War(@Param("team") String team);
}
