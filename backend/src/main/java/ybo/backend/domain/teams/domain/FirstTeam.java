package ybo.backend.domain.teams.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ybo.backend.domain.realtime.domain.RealtimeGame;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FirstTeam {

    @Id @GeneratedValue
    @Column(name = "first_team_id")
    private Long id;

    @Column(name = "team")
    private String team;
    @Column(name = "c")
    private String C;
    @Column(name = "fb")
    private String FB;
    @Column(name = "sb")
    private String SB;
    @Column(name = "tb")
    private String TB;
    @Column(name = "ss")
    private String SS;
    @Column(name = "rf")
    private String RF;
    @Column(name = "cf")
    private String CF;
    @Column(name = "lf")
    private String LF;
    @Column(name = "p")
    private String P;
    @Column(name = "dh")
    private String DH;

    public static FirstTeam createFirstTeam(String team, String C, String FB, String SB, String TB, String SS, String RF,
                                            String CF, String LF, String P, String DH){
        return FirstTeam.builder().team(team).C(C).FB(FB).SB(SB).TB(TB)
                .SS(SS).RF(RF).CF(CF).LF(LF).P(P).DH(DH).build();
    }
}
