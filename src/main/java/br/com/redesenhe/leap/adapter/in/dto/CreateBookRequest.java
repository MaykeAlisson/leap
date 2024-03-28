package br.com.redesenhe.leap.adapter.in.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateBookRequest(
        @NotBlank
        String name,
        @NotBlank
        String author
) {
}
