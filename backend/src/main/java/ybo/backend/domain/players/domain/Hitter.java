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
public class Hitter {
    // 이름 팀 OPS 게임수 타석 타율 안타 홈런 타점 도루 삼진 병살 WAR
    @Id @GeneratedValue
    @Column(name = "hitter_id")
    @JsonIgnore
    private Long id;
    private String name;
    private String team;
    private Float ops;
    private Integer games; // 게임수
    private Integer pa; // 타석
    private Float ba; // 타율
    private Integer hit; // 안타
    private Integer homerun; // 홈런
    private Integer rbi; // 타점
    private Integer steal; // 도루
    private Integer strikeout; // 삼진
    private Integer dp; // 병살
    private Float war; // WAR
    private Float obp; // 출루율
    private Float slg; // 장타율

    public static Hitter createHitter(String name, String team, Float ops, Integer games, Integer pa, Float ba, Integer hit,
                               Integer homerun, Integer rbi, Integer steal, Integer strikeout, Integer dp,
                               Float war, Float obp, Float slg){
        return Hitter.builder().name(name).team(team).ops(ops).games(games).pa(pa).ba(ba).hit(hit)
                        .homerun(homerun).rbi(rbi).steal(steal).strikeout(strikeout).dp(dp)
                        .war(war).obp(obp).slg(slg).build();
    }
}

