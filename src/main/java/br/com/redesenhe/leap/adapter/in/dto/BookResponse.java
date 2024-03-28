package br.com.redesenhe.leap.adapter.in.dto;

import java.time.Year;

public record BookResponse(
        Integer id,
        String name,
        String author,
        Integer pages,
        Boolean finish,
        Year year,
        Boolean desire,
        String imageLink
) {
}
