package ybo.backend.domain.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ybo.backend.domain.test.domain.Text;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TextSaveRequestDto {

    @NotBlank(message = "댓글은 공백일 수 없습니다. ")
    private String value;

    public Text createEntityByDto(){
        return new Text(this.value);
    }
}

