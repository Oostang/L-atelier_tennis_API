package com.example.tennisapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public record PlayerDto (
        @NotNull
        int id,

        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @NotBlank
        String shortName,

        @NotBlank
        char sex,

        @NotNull
        CountryDto country,

        @URL
        @NotBlank
        String picture,

        @NotNull
        DataDto data
) implements Comparable<PlayerDto>{
        @Override
        public int compareTo(PlayerDto o) {
                return Short.compare(this.data.rank(), o.data().rank());
        }
}
