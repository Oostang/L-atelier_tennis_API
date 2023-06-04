package com.example.tennisapi.mapper;

import com.example.tennisapi.dto.DataDto;
import com.example.tennisapi.model.Data;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface DataMapper {

    DataMapper INSTANCE = Mappers.getMapper(DataMapper.class);

    Data toEntity(DataDto dataDto);

    DataDto toDto(Data data);
}
