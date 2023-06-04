package com.example.tennisapi.mapper;

import com.example.tennisapi.dto.CountryDto;
import com.example.tennisapi.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Mapping(target = "pictureUrl", source = "countryDto.picture")
    Country toEntity(CountryDto countryDto);

    @Mapping(target = "picture", source = "country.pictureUrl")
    CountryDto toDto(Country country);
}
