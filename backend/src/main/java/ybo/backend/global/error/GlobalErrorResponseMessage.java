package ybo.backend.global.error;

public class GlobalErrorResponseMessage {

    public static final String ILLEGAL_ARGUMENT_ERROR = "올바르지 않은 요청 데이터입니다.";
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 에러";
    public static final String REQUEST_METHOD_ERROR = "정의되지 않은 요청입니다. HTTP 메소드를 확인해주세요.";
    public static final String REQUEST_URL_ERROR = "정의되지 않은 요청입니다. 요청 URL을 확인해주세요.";

    public static final String ILLEGAL_TYPE_CONVERSION_ERROR = "값 타입 변환에 실패하였습니다. 올바른 값 타입인지 확인해 주세요. 예를 들어 comment 는 String 타입이어야 합니다.";

}