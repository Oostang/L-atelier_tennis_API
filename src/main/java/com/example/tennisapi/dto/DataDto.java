package com.example.tennisapi.dto;

import java.util.Arrays;
import java.util.Objects;

public record DataDto(
        short rank,
        int points,
        int weight,
        short height,
        byte age,
        char[] last
) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataDto dataDto = (DataDto) o;
        return rank == dataDto.rank && points == dataDto.points && weight == dataDto.weight && height == dataDto.height && age == dataDto.age && Arrays.equals(last, dataDto.last);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rank, points, weight, height, age);
        result = 31 * result + Arrays.hashCode(last);
        return result;
    }

    @Override
    public String toString() {
        return "DataDto{" +
                "rank=" + rank +
                ", points=" + points +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", last=" + Arrays.toString(last) +
                '}';
    }
}
