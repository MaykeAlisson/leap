package br.com.redesenhe.leap.adapter.exception.handler;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class RestTemplateResponseErrorHandler extends ResponseErrorHandler {


    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().isError());
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

    }
}
