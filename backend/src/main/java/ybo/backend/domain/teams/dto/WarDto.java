package ybo.backend.domain.teams.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import ybo.backend.domain.teams.domain.WarList;

import java.util.List;

@AllArgsConstructor
public class WarDto {
    @JsonProperty("warTop5")
    private List<WarList> warListTop5;
    @JsonProperty("warLow5")
    private List<WarList> warListLow5;
}
