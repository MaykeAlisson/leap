package br.com.redesenhe.leap.adapter.in.controller;


import br.com.redesenhe.leap.adapter.exception.handler.response.ApiErrorResponse;
import br.com.redesenhe.leap.adapter.in.dto.CreateUserRequest;
import br.com.redesenhe.leap.adapter.in.dto.UserAcessResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "User", description = "Operações para Usuario")
public interface UserControllerSwagger {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario criado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserAcessResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Falha ao validar requisição", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))
            })
    })
    ResponseEntity<UserAcessResponse> create(CreateUserRequest createUserRequest);
}
