package br.com.redesenhe.leap.adapter.in.controller.impl;

import br.com.redesenhe.leap.adapter.in.controller.GoalControllerSwagger;
import br.com.redesenhe.leap.adapter.provider.PreAuthorizeProvider;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/goals", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class GoalController implements GoalControllerSwagger {
    @PostMapping
    @Override
    @PreAuthorize(PreAuthorizeProvider.IS_AUTHENTICATED)
    public ResponseEntity<Void> create() {
        return null;
    }
}
