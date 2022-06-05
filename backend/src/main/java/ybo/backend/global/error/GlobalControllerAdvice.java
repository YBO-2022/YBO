package ybo.backend.global.error;


import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;
import ybo.backend.global.error.exception.CustomIllegalArgumentException;
import ybo.backend.global.response.StatusCode;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {


    @ExceptionHandler(CustomIllegalArgumentException.class)
    public ErrorResponse illegalExHandle(CustomIllegalArgumentException e) {
        log.error("[ExceptionHandle] CustomIllegalArgumentException: ", e);
        BindingResult bindingResult = e.getBindingResult();
        List<FieldErrorInfo> fieldErrorInfo = new ArrayList<>();
        bindingResult.getFieldErrors().stream()
                .forEach(error-> fieldErrorInfo.add(new FieldErrorInfo(error.getField(), error.getDefaultMessage())));
        return new ErrorResponse(StatusCode.BAD_REQUEST, e.getMessage(), fieldErrorInfo);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponse illegalExHandle(IllegalArgumentException e) {
        log.error("[ExceptionHandle] IllegalArgumentException: ", e);
        return new ErrorResponse(StatusCode.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErrorResponse converterExHandle(HttpRequestMethodNotSupportedException e) {
        log.error("[ExceptionHandle] HttpRequestMethodNotSupportedException: ", e.getMessage());
        return ErrorResponse.res(StatusCode.METHOD_NOT_ALLOWED, GlobalErrorResponseMessage.REQUEST_METHOD_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ErrorResponse notFoundExceptionHandle(NoHandlerFoundException e) {
        log.error("[ExceptionHandle] NoHandlerFoundException: ", e);
        return ErrorResponse.res(StatusCode.NOT_FOUND, GlobalErrorResponseMessage.REQUEST_URL_ERROR);
    }


    @ExceptionHandler
    public ErrorResponse exHandle(Exception e) {
        log.error("[ExceptionHandle] Exception: ", e);
        return new ErrorResponse(StatusCode.INTERNAL_SERVER_ERROR, GlobalErrorResponseMessage.INTERNAL_SERVER_ERROR);
    }

   // @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse exHandle(MethodArgumentTypeMismatchException e) {
        log.error("[ExceptionHandle] Exception: ", e);
        return new ErrorResponse(StatusCode.INTERNAL_SERVER_ERROR, GlobalErrorResponseMessage.ILLEGAL_TYPE_CONVERSION_ERROR);
    }


}

