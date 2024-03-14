package br.com.redesenhe.leap.application.core.domain.exception;

public class ServerErrorExceptionHandler extends RuntimeException {


    public ServerErrorExceptionHandler(Integer errorCode, String errorMsg, Throwable cause){
        super(errorMsg, cause);
        this.errorCode = Integer.toString(errorCode);
        this.errorMsg = errorMsg;
    }

    public ServerErrorExceptionHandler(Integer errorCode, String errorMsg){
        super(errorMsg);
        this.errorCode = Integer.toString(errorCode);
        this.errorMsg = errorMsg;
    }

    private final String errorCode;
    private final String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
