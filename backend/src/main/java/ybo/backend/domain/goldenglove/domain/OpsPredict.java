package ybo.backend.domain.goldenglove.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpsPredict {
    @Id @GeneratedValue
    @Column(name = "ops_predict_id")
    private Long id;
    private String name;
    private String team;
    private Float ops;
    private Float predictOps;

    public static OpsPredict createOpsPredict(String name, String team, Float ops, Float predictOps){
        return OpsPredict.builder().name(name).team(team).ops(ops).predictOps(predictOps).build();
    }
}
