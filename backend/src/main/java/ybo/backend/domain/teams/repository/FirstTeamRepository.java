package ybo.backend.domain.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ybo.backend.domain.teams.domain.FirstTeam;

public interface FirstTeamRepository extends JpaRepository<FirstTeam, Long> {
    FirstTeam findByTeam(String team);
}
