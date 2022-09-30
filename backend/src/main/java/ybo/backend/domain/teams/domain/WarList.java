package ybo.backend.domain.teams.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WarList {
    @Id @GeneratedValue
    @Column(name = "war_list_id")
    private Long id;

    private String name;
    private Float war;
    private String team;
}
