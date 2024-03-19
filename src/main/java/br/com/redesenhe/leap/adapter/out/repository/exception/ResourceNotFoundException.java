package br.com.redesenhe.leap.adapter.out.repository.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException( String errorMsg){
        super(errorMsg);
        this.errorCode = "404";
        this.errorMsg = errorMsg;
    }
    public ResourceNotFoundException(Integer errorCode, String errorMsg, Throwable cause){
        super(errorMsg, cause);
        this.errorCode = Integer.toString(errorCode);
        this.errorMsg = errorMsg;
    }

    public ResourceNotFoundException(Integer errorCode, String errorMsg){
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
