package ybo.backend.domain.players.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pitcher {

    // 이름, 팀, 'ERA', 'WAR', '승', '패', '이닝', '실점', '자책','피안타','홈런', '볼넷', '삼진'
    @Id @GeneratedValue
    @Column(name = "pitcher_id")
    @JsonIgnore
    private Integer pitcherId;
    private String name;
    private String team;
    private Float era;
    private Float war;
    private Integer win;
    private Integer lose;
    private Integer save;
    private Integer hold;
    private Float inning;
    private Integer runs;
    private Integer earnedRun;
    private Integer hit;
    private Integer homerun;
    private Integer bb;
    private Integer strikeout;
}
