package br.com.redesenhe.leap.adapter.in.controller.impl;

import br.com.redesenhe.leap.adapter.in.controller.GoalControllerSwagger;
import br.com.redesenhe.leap.adapter.in.dto.BookResponse;
import br.com.redesenhe.leap.adapter.in.dto.CreateBookRequest;
import br.com.redesenhe.leap.adapter.in.mapper.BookMapper;
import br.com.redesenhe.leap.adapter.in.mapper.UserMapper;
import br.com.redesenhe.leap.adapter.out.InsertBookAdapter;
import br.com.redesenhe.leap.adapter.provider.PreAuthorizeProvider;
import br.com.redesenhe.leap.application.ports.in.InsertUserInputPort;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/goals", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class GoalController implements GoalControllerSwagger {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoalController.class);

    @Autowired
    private InsertBookAdapter insertBookAdapter;

    @Autowired
    private BookMapper mapper;

    @PostMapping(value = "/books")
    @Override
    @PreAuthorize(PreAuthorizeProvider.IS_AUTHENTICATED)
    public ResponseEntity<BookResponse> create(@RequestBody @Valid CreateBookRequest request) {
        LOGGER.info("Init create goal book...");
        var book = this.insertBookAdapter.execute(mapper.toBook(request));
        return ResponseEntity.status(201).body(this.mapper.toBookResponse(book));
    }
}
