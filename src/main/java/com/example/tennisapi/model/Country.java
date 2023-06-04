package com.example.tennisapi.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import java.util.Objects;

@Embeddable
public class Country {

    @URL
    @NotBlank
    private String pictureUrl;

    @NotBlank
    private String code;

    public Country() {
    }

    public Country(String pictureUrl, String code) {
        this.pictureUrl = pictureUrl;
        this.code = code;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String picture) {
        this.pictureUrl = picture;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return pictureUrl.equals(country.pictureUrl) && code.equals(country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pictureUrl, code);
    }

}
