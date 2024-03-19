package br.com.redesenhe.leap.adapter.in.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthenticationRequest(
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 6, message = "{validation.name.size.too_short}")
        String password
) {

}
