package ybo.backend.domain.teams.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import ybo.backend.domain.teams.domain.War;

import java.util.List;

@AllArgsConstructor
public class WarDto {
    @JsonProperty("warTop5")
    private List<War> warTop5;
    @JsonProperty("warLow5")
    private List<War> warLow5;
}
