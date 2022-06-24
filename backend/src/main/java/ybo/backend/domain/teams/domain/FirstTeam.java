package ybo.backend.domain.teams.domain;

import lombok.AllArgsConstructor;
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
public class FirstTeam {
    @Id
    @GeneratedValue
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
}
