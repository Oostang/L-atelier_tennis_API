package com.example.tennisapi.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

import java.util.Objects;

@Entity
public class Player implements Comparable<Player> {

    @Id
    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String shortName;

    @NotBlank
    private char sex;

    @NotNull
    @Embedded
    private Country country;

    @URL
    @NotBlank
    private String picture;

    @NotNull
    @Embedded
    private Data data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public int compareTo(Player o) {
        return Short.compare(this.data.getRank(), o.getData().getRank());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && sex == player.sex && Objects.equals(firstName, player.firstName) && Objects.equals(lastName, player.lastName) && Objects.equals(shortName, player.shortName) && Objects.equals(country, player.country) && Objects.equals(picture, player.picture) && Objects.equals(data, player.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, shortName, sex, country, picture, data);
    }
}
