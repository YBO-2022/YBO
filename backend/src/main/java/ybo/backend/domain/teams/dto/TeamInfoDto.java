package ybo.backend.domain.teams.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import ybo.backend.domain.teams.domain.SeasonHighLow;
import ybo.backend.domain.teams.domain.VictoryNum;

import java.util.List;

@AllArgsConstructor
public class TeamInfoDto {
    @JsonProperty("victory_num")
    private VictoryNum victoryNum;
    @JsonProperty("realtime_ranking")
    private Integer ranking;
    @JsonProperty("season_high_low")
    private SeasonHighLow seasonHighLow;
}
