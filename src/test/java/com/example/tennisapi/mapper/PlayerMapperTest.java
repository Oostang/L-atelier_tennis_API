package com.example.tennisapi.mapper;

import com.example.tennisapi.dto.CountryDto;
import com.example.tennisapi.dto.DataDto;
import com.example.tennisapi.dto.PlayerDto;
import com.example.tennisapi.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.tennisapi.util.PlayerGenerator.getNovak;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class PlayerMapperTest {

    @Test
    void toDto() {
        //Given
        Player player = getNovak();

        //When
        PlayerDto playerDto = PlayerMapper.INSTANCE.toDto(player);

        //Then
        assertNotNull(playerDto);
        assertEquals("id should be equals", playerDto.id(), player.getId());
        assertEquals("first name should be equals", playerDto.firstName(), player.getFirstName());
        assertEquals("last name should be equals", playerDto.lastName(), player.getLastName());
        assertEquals("short name should be equals", playerDto.shortName(), player.getShortName());
        assertEquals("sex should be equals", playerDto.sex(), player.getSex());
        assertEquals("country picture should be equals", playerDto.country().picture(), player.getCountry().getPictureUrl());
        assertEquals("country code should be equals", playerDto.country().code(), player.getCountry().getCode());
        assertEquals("player picture should be equals", playerDto.picture(), player.getPicture());
        assertEquals("player rank should be equals", playerDto.data().rank(), player.getData().getRank());
        assertEquals("player points should be equals", playerDto.data().points(), player.getData().getPoints());
        assertEquals("player weight should be equals", playerDto.data().weight(), player.getData().getWeight());
        assertEquals("player height should be equals", playerDto.data().height(), player.getData().getHeight());
        assertEquals("player age should be equals", playerDto.data().age(), player.getData().getAge());
        assertEquals("player lasts should be equals", playerDto.data().last(), player.getData().getLast());
    }

    @Test
    void toEntity() {
        //given
        PlayerDto playerDto = new PlayerDto(
                52,
                "Novak",
                "Djokovic",
                "N.DJO",
                'M',
                new CountryDto("https://data.latelier.co/training/tennis_stats/resources/Serbie.png", "SRB"),
                "https://data.latelier.co/training/tennis_stats/resources/Djokovic.png",
                new DataDto(
                        (short) 2,
                        2542,
                        80000,
                        (short) 188,
                        (byte) 31,
                        new char[]{
                                '1',
                                '1',
                                '1',
                                '1',
                                '1'
                        }
                )
        );

        //When
        Player player = PlayerMapper.INSTANCE.toEntity(playerDto);

        //Then
        assertNotNull(player);
        assertEquals("id should be equals", playerDto.id(), player.getId());
        assertEquals("first name should be equals", playerDto.firstName(), player.getFirstName());
        assertEquals("last name should be equals", playerDto.lastName(), player.getLastName());
        assertEquals("short name should be equals", playerDto.shortName(), player.getShortName());
        assertEquals("sex should be equals", playerDto.sex(), player.getSex());
        assertEquals("country picture should be equals", playerDto.country().picture(), player.getCountry().getPictureUrl());
        assertEquals("country code should be equals", playerDto.country().code(), player.getCountry().getCode());
        assertEquals("player picture should be equals", playerDto.picture(), player.getPicture());
        assertEquals("player rank should be equals", playerDto.data().rank(), player.getData().getRank());
        assertEquals("player points should be equals", playerDto.data().points(), player.getData().getPoints());
        assertEquals("player weight should be equals", playerDto.data().weight(), player.getData().getWeight());
        assertEquals("player height should be equals", playerDto.data().height(), player.getData().getHeight());
        assertEquals("player age should be equals", playerDto.data().age(), player.getData().getAge());
        assertEquals("player lasts should be equals", playerDto.data().last(), player.getData().getLast());
    }
}
