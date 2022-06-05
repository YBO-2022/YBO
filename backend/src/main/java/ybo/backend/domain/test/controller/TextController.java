package ybo.backend.domain.test.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ybo.backend.domain.test.domain.Text;
import ybo.backend.domain.test.dto.TextSaveRequestDto;
import ybo.backend.domain.test.service.TextService;
import ybo.backend.global.error.GlobalErrorResponseMessage;
import ybo.backend.global.error.exception.CustomIllegalArgumentException;
import ybo.backend.global.response.DefaultResponse;
import ybo.backend.global.response.StatusCode;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
// @RequestMapping("/api")
public class TextController {

    private final TextService textService;

    @PostMapping("/api/value")
    public DefaultResponse saveText(@RequestBody TextSaveRequestDto textSaveRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new CustomIllegalArgumentException(GlobalErrorResponseMessage.ILLEGAL_ARGUMENT_ERROR, bindingResult);
        }
        Text savedText = textService.save(textSaveRequestDto.createEntityByDto());
        return DefaultResponse.res(StatusCode.OK, TextResponseMessage.COMMENT_SAVE_SUCCESS, savedText);
    }

    @GetMapping("/api/values")
    public DefaultResponse findAllTexts() {
        List<Text> texts = textService.findAll();
        return DefaultResponse.res(StatusCode.OK, TextResponseMessage.FIND_ALL_SUCCESS, texts);
    }

}