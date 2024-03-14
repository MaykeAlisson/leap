package br.com.redesenhe.leap.adapter.exception.handler;

import br.com.redesenhe.leap.adapter.exception.handler.response.ApiErrorResponse;
import br.com.redesenhe.leap.adapter.exception.handler.response.ValidateError;
import br.com.redesenhe.leap.adapter.out.repository.exception.ResourceNotFoundException;
import br.com.redesenhe.leap.application.core.domain.exception.BusinessExceptionHandler;
import br.com.redesenhe.leap.application.core.domain.exception.ServerErrorExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ControllerAdvice
@AllArgsConstructor
public class RestTemplateResponseErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Set<ValidateError>> handle(MethodArgumentNotValidException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Set<ValidateError> errors = new HashSet<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            ValidateError erro = new ValidateError(e.getField(), e.getDefaultMessage());
            errors.add(erro);
        });


        return ResponseEntity.status(status).body(errors);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource nou found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiErrorResponse err = new ApiErrorResponse(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(BusinessExceptionHandler.class)
    public ResponseEntity<ApiErrorResponse> resourceBussinesException(BusinessExceptionHandler e, HttpServletRequest request) {
        String error = "Business exception";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiErrorResponse err = new ApiErrorResponse(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiErrorResponse> resourceForbiddenException(AccessDeniedException e, HttpServletRequest request) {
        String error = "Forbidden exception";
        HttpStatus status = HttpStatus.FORBIDDEN;
        ApiErrorResponse err = new ApiErrorResponse(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> httpClientErrorException(HttpClientErrorException ex, WebRequest request) {
        String error = "HttpClient exception";
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ApiErrorResponse err = new ApiErrorResponse(Instant.now(), status.value(), error, ex.getMessage(), request.getContextPath());
        return ResponseEntity.status(status).body(err);
    }

//    @Override
//    public boolean hasError(ClientHttpResponse response) throws IOException {
//        return (response.getStatusCode().isError());
//    }
//
//    @Override
//    public void handleError(ClientHttpResponse response) throws IOException {
//        ServerErrorExceptionHandler seh = new ServerErrorExceptionHandler(response.getStatusCode().value(),
//                "Houve um erro que impediu atender a requisicao " + response.getStatusText());
//
//        if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()){
//            throw seh;
//        }else {
//            UnknownHttpStatusCodeException unknownHttpStatusCode = new UnknownHttpStatusCodeException("",
//                    response.getStatusCode().value(),
//                    response.getStatusText(),
//                    response.getHeaders(), null, null
//            );
//
//            seh = new ServerErrorExceptionHandler(response.getStatusCode().value(), "Houve um erro que impediu atender a requisicao " + response.getStatusText(), unknownHttpStatusCode);
//        }
//
//        throw seh;
//    }
}
