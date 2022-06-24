package ybo.backend.domain.teams.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class War {
    @Id
    @GeneratedValue
    private String name;
    private Float war;
    private String team;
}
