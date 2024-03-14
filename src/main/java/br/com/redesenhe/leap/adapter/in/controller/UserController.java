package br.com.redesenhe.leap.adapter.in.controller;


import br.com.redesenhe.leap.adapter.in.dto.CreateUserRequest;
import br.com.redesenhe.leap.adapter.in.dto.UserAcessResponse;
import br.com.redesenhe.leap.adapter.in.mapper.UserMapper;
import br.com.redesenhe.leap.application.core.domain.model.User;
import br.com.redesenhe.leap.application.ports.in.InsertUserInputPort;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController implements UserControllerSwagger{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private InsertUserInputPort insertUserInputPort;
    @Autowired
    private UserMapper mapper;


    @PostMapping
    @Override
    public ResponseEntity<UserAcessResponse> create(@Valid @RequestBody final CreateUserRequest createUserRequest) {
        LOGGER.info("Init create user...");
        User execute = this.insertUserInputPort.execute(mapper.toUser(createUserRequest));
        UserAcessResponse userAcessResponse = this.mapper.toUserAcessResponse(execute);
        return ResponseEntity.status(HttpStatus.CREATED).body(userAcessResponse);
    }


}
