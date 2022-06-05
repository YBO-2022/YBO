package ybo.backend.domain.test.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity @Getter
@AllArgsConstructor
@NoArgsConstructor
public class Text {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private String value;

    public Text(String comment){
        this.value = comment;
    }
}
