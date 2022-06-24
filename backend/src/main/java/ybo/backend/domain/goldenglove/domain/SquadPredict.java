package ybo.backend.domain.goldenglove.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SquadPredict {
    @Id @GeneratedValue
    private String position;
    private String team;
    private String name;
}
