package ybo.backend.global.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FieldErrorInfo{
    private String field;
    private String errorMessage;
}