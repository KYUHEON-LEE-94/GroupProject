package lee.GroupProject.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    //400 BAD_REQUEST 잘못된 요청
    INVALID_PARAMETER(400, "파라미터 값을 확인해주세요."),

    //404 NOT_FOUND 잘못된 리소스 접근
    DISPLAY_NOT_FOUND(404, "죄송합니다. 유효하지 않은 요청입니다(404). 주소를 확인해 주세요."),

    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, "서버 에러입니다. 서버 팀에 연락주세요!"),

    //LoginError
    LOGIN_ERROR(401, "로그인이 필요한 서비스입니다..");

    private final int status;
    private final String message;
}
