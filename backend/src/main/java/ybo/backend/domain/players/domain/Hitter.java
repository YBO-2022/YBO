package ybo.backend.domain.players.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hitter {
    // 이름 팀 OPS 게임수 타석 타율 안타 홈런 타점 도루 삼진 병살 WAR
    @Id @GeneratedValue
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
}

