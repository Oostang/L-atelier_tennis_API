package com.example.tennisapi.dto;

public record StatsDto(
        CountryDto bestCountry,

        double averageIMC,

        int medianHeight
) {
}
