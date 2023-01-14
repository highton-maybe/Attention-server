package maybe.attention.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    MEMBER_NOT_FOUND("존재하지 않는 회원입니다.", 404),
    MISMATCH_MEMBER_PASSWORD("비밀번호가 일치하지 않습니다.", 400),
    ALREADY_EXIST_EMAIL("이미 존재하는 이메일입니다." , 400),
    TOKEN_NOT_VALID("토큰이 유효 하지 않습니다.", 401),
    TOKEN_EXPIRATION("토큰이 만료 되었습니다.", 401),
    REFRESH_TOKEN_NOT_FOUND("존재하지 않는 리프레시 토큰입니다.", 404);

    private final String message;
    private final int status;

}
