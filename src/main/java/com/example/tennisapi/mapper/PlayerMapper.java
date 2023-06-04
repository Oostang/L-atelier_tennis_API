package com.example.tennisapi.mapper;

import com.example.tennisapi.dto.PlayerDto;
import com.example.tennisapi.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "country.pictureUrl", source = "country.picture")
    Player toEntity(PlayerDto playerDto);

    @Mapping(target = "country.picture", source = "country.pictureUrl")
    PlayerDto toDto(Player player);
}
