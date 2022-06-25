package ybo.backend.domain.players.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ybo.backend.domain.players.domain.Hitter;

import java.util.List;

@AllArgsConstructor
public class HitterRankingDto {
    @JsonProperty("top3_Ba")
    List<Hitter> top3Ba;
    @JsonProperty("top3_Obp")
    List<Hitter> top3Obp;
    @JsonProperty("top3_Slg")
    List<Hitter> top3Slg;
    @JsonProperty("top3_Rbi")
    List<Hitter> top3Rbi;
    @JsonProperty("top3_Homerun")
    List<Hitter> top3Homerun;
    @JsonProperty("top3_Steal")
    List<Hitter> top3Steal;
}
