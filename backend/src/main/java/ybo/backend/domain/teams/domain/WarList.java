package ybo.backend.domain.teams.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarList {
    @Id @GeneratedValue
    @Column(name = "war_list_id")
    private Long id;

    private String name;
    private Float war;
    private String team;

    public static WarList createWarList(String name, Float war, String team){
        return WarList.builder().name(name).war(war).team(team).build();
    }
}
