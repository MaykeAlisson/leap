package br.com.redesenhe.leap.adapter.in.dto;

import java.time.Instant;

public record UserAcessResponse(
        String name,
        String token,
        Instant expiration
) {
}
