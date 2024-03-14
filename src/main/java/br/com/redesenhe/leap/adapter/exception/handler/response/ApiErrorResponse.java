package br.com.redesenhe.leap.adapter.exception.handler.response;
import java.time.Instant;

public record ApiErrorResponse (
     Instant timestamp,
     Integer status,
     String error,
     String message,
     String path
    ){
}