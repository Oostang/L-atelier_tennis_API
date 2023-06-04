package com.example.tennisapi.model;

import jakarta.persistence.Embeddable;

import java.util.Arrays;
import java.util.Objects;

@Embeddable
public class Data {
    private short rank;
    private int points;
    private int weight;
    private short height;
    private byte age;
    private char[] last;

    public Data() {
    }

    public Data(short rank, int points, int weight, short height, byte age, char[] last) {
        this.rank = rank;
        this.points = points;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.last = last;
    }

    public short getRank() {
        return rank;
    }

    public void setRank(short rank) {
        this.rank = rank;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public short getHeight() {
        return height;
    }

    public void setHeight(short height) {
        this.height = height;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public char[] getLast() {
        return last;
    }

    public void setLast(char[] last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return rank == data.rank && points == data.points && weight == data.weight && height == data.height && age == data.age && Arrays.equals(last, data.last);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rank, points, weight, height, age);
        result = 31 * result + Arrays.hashCode(last);
        return result;
    }
}
