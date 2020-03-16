package com.rechecking.exception;

import com.rechecking.enums.ResultFailureEnum;

public class PaperException extends RuntimeException {
    
    private Integer code;
    
    public PaperException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    
    public PaperException(ResultFailureEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
