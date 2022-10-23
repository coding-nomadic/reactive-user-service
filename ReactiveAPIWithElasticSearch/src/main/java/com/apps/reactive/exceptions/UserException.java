package com.apps.reactive.exceptions;
/**
 * 
 * @author Tenzin Dawa
 *
 */
public class UserException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final String code;
    public UserException(String message, String code) {
        super(message);
        this.code = code;
    }

    public UserException(String message, String code, Throwable thrownException) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
