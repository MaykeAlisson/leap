package br.com.redesenhe.leap.adapter.in.dto;

import java.time.Instant;
import java.util.Date;

public record UserAcessResponse(
        String name,
        String token,
        Date expiration
) {
}
