package com.rakku.covidinline.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Predicate;

import static com.rakku.covidinline.constant.ErrorCode.ErrorCategory.*;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    OK(0, NORMAL, "OK"),

    BAD_REQUEST(10000, CLIENT_SIDE, "bad request"),
    SPRING_BAD_REQUEST(10001, CLIENT_SIDE, "Spring-detected bad request"),

    INTERNAL_ERROR(20000, SERVER_SIDE, "internal error"),
    SPRING_INTERNAL_ERROR(20001, SERVER_SIDE, "Spring-detected internal error")
    ;

    private final Integer code;
    private final ErrorCategory errorCategory;
    private final String message;

    public String getMessage(Exception e){
        return getMessage(e.getMessage());
    }

    public String getMessage(String message){
        return Optional.ofNullable(message)
                .filter(Predicate.not(String::isBlank))
                .orElse(getMessage());
    }

    public boolean isClientSideError(){
        return this.errorCategory == CLIENT_SIDE;
    }

    public boolean isServerSideError(){
        return this.errorCategory == SERVER_SIDE;
    }

    @Override
    public String toString(){
        return String.format("%s (%d)", name(), this.getCode());
    }

    public enum ErrorCategory{
        NORMAL, CLIENT_SIDE, SERVER_SIDE
    }
}
