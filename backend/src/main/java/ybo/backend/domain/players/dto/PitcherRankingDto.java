package ybo.backend.domain.players.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import ybo.backend.domain.players.domain.Hitter;
import ybo.backend.domain.players.domain.Pitcher;

import java.util.List;

@AllArgsConstructor
public class PitcherRankingDto {
    @JsonProperty("top3_Win")
    List<Pitcher> top3Win;
    @JsonProperty("top3_Era")
    List<Pitcher> top3Era;
    @JsonProperty("top3_Earned_run")
    List<Pitcher> top3EarnedRun;
    @JsonProperty("top3_Save")
    List<Pitcher> top3Save;
    @JsonProperty("top3_Hold")
    List<Pitcher> top3Hold;
    @JsonProperty("top3_Strikeout")
    List<Pitcher> top3Strikeout;
}
