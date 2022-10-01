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
@Builder
public class Pitcher {

    // 이름, 팀, 'ERA', 'WAR', '승', '패', '이닝', '실점', '자책','피안타','홈런', '볼넷', '삼진'
    @Id @GeneratedValue
    @Column(name = "pitcher_id")
    @JsonIgnore
    private Long id;
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

    public static Pitcher createPitcher(String name, String team, Float era, Float war, Integer win, Integer lose,
                                        Integer save, Integer hold, Float inning, Integer runs, Integer earnedRun,
                                        Integer hit, Integer homerun, Integer bb, Integer strikeout){
        return Pitcher.builder().name(name).team(team).era(era).war(war).win(win).lose(lose)
                .save(save).hold(hold).inning(inning).runs(runs).earnedRun(earnedRun)
                .hit(hit).homerun(homerun).bb(bb).strikeout(strikeout).build();
    }
}
