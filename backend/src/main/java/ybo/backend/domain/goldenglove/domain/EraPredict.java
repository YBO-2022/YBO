package ybo.backend.domain.goldenglove.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ybo.backend.domain.players.domain.Hitter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EraPredict {
    @Id @GeneratedValue
    @Column(name = "era_predict_id")
    private Long id;
    private String name;
    private String team;
    private Float era;
    private Float predictEra;

    public static EraPredict createEraPredict(String name, String team, Float era, Float predictEra){
        return EraPredict.builder().name(name).team(team).era(era).predictEra(predictEra).build();
    }

}