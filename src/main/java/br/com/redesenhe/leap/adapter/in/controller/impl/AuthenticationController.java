package br.com.redesenhe.leap.adapter.in.controller.impl;

import br.com.redesenhe.leap.adapter.in.controller.AuthenticationControllerSwagger;
import br.com.redesenhe.leap.adapter.in.dto.AuthenticationRequest;
import br.com.redesenhe.leap.adapter.in.dto.UserAcessResponse;
import br.com.redesenhe.leap.adapter.in.mapper.UserMapper;
import br.com.redesenhe.leap.adapter.out.AuthenticationUserAdapter;
import br.com.redesenhe.leap.adapter.provider.Date;
import br.com.redesenhe.leap.application.core.domain.model.User;
import br.com.redesenhe.leap.application.ports.in.AuthenticationUserInputPort;
import br.com.redesenhe.leap.application.ports.in.InsertUserInputPort;
import br.com.redesenhe.leap.config.jwt.JwtProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static br.com.redesenhe.leap.config.jwt.JwtProvider.JWT_TOKEN_VALIDITY;

@RestController
@RequestMapping(value = "/v1/auths", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController implements AuthenticationControllerSwagger {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationUserAdapter authenticationUserAdapter;

    @Autowired
    private UserMapper mapper;

    @PostMapping(value = "/login")
    @Override
    public ResponseEntity<UserAcessResponse> login(@RequestBody @Valid final AuthenticationRequest request){
        LOGGER.info("Init login...");
        System.out.println(request);
        User execute = this.authenticationUserAdapter.execute(mapper.toUser(request));
        final String token = JwtProvider.gerar(execute.getId(), 1L)
                .orElseThrow(() -> new RuntimeException("Nao foi possivel gerar token"));
        var expiration = Date.toDate(JWT_TOKEN_VALIDITY);
        UserAcessResponse userAcessResponse = this.mapper.toUserAcessResponse(execute,token, expiration);
        return ResponseEntity.ok(userAcessResponse);
    }
}
