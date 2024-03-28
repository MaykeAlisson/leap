package br.com.redesenhe.leap.adapter.in.controller;

import br.com.redesenhe.leap.adapter.exception.handler.response.ApiErrorResponse;
import br.com.redesenhe.leap.adapter.in.dto.BookResponse;
import br.com.redesenhe.leap.adapter.in.dto.CreateBookRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Metas", description = "Operações para metas")
public interface GoalControllerSwagger {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Meta criado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = BookResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Falha ao validar requisição", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))
            })
    })
    ResponseEntity<BookResponse> create(@RequestBody @Valid CreateBookRequest request);

}
