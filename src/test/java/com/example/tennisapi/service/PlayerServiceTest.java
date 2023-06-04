package com.example.tennisapi.service;

import com.example.tennisapi.dto.PlayerDto;
import com.example.tennisapi.mapper.PlayerMapper;
import com.example.tennisapi.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.example.tennisapi.util.PlayerGenerator.*;
import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
class PlayerServiceTest {

    @Autowired
    public PlayerService service;


    @Test
    void testGetAllPlayers() {
        SortedSet<PlayerDto> checkSet = new TreeSet<>(
                Set.of(PlayerMapper.INSTANCE.toDto(getRafael()),
                        PlayerMapper.INSTANCE.toDto(getNovak()),
                        PlayerMapper.INSTANCE.toDto(getSerena()),
                        PlayerMapper.INSTANCE.toDto(getStan()),
                        PlayerMapper.INSTANCE.toDto(getVenus())
                ));
        SortedSet<Player> players = service.getAllPlayers();

        //first player
        assertEquals("Ids should be equals", checkSet.first().id(), players.first().getId());
        assertEquals("First Names should be equals", checkSet.first().firstName(), players.first().getFirstName());
        assertEquals("Last names should be equals", checkSet.first().lastName(), players.first().getLastName());
        assertEquals("Short names should be equals", checkSet.first().shortName(), players.first().getShortName());
        assertEquals("Sexes should be equals", checkSet.first().sex(), players.first().getSex());
        assertEquals("Country pictures should be equals", checkSet.first().country().picture(), players.first().getCountry().getPictureUrl());
        assertEquals("Country codes should be equals", checkSet.first().country().code(), players.first().getCountry().getCode());
        assertEquals("Pictures should be equals", checkSet.first().picture(), players.first().getPicture());
        assertEquals("Ranks should be equals", checkSet.first().data().rank(), players.first().getData().getRank());
        assertEquals("Points should be equals", checkSet.first().data().points(), players.first().getData().getPoints());
        assertEquals("Weights should be equals", checkSet.first().data().weight(), players.first().getData().getWeight());
        assertEquals("Heights should be equals", checkSet.first().data().height(), players.first().getData().getHeight());
        assertEquals("Ages should be equals", checkSet.first().data().age(), players.first().getData().getAge());
        assertEquals("Lasts should be equals", checkSet.first().data().last(), players.first().getData().getLast());

        //last player
        assertEquals("Ids should be equals", checkSet.last().id(), players.last().getId());
        assertEquals("First Names should be equals", checkSet.last().firstName(), players.last().getFirstName());
        assertEquals("Last names should be equals", checkSet.last().lastName(), players.last().getLastName());
        assertEquals("Short names should be equals", checkSet.last().shortName(), players.last().getShortName());
        assertEquals("Sexes should be equals", checkSet.last().sex(), players.last().getSex());
        assertEquals("Country pictures should be equals", checkSet.last().country().picture(), players.last().getCountry().getPictureUrl());
        assertEquals("Country codes should be equals", checkSet.last().country().code(), players.last().getCountry().getCode());
        assertEquals("Pictures should be equals", checkSet.last().picture(), players.last().getPicture());
        assertEquals("Ranks should be equals", checkSet.last().data().rank(), players.last().getData().getRank());
        assertEquals("Points should be equals", checkSet.last().data().points(), players.last().getData().getPoints());
        assertEquals("Weights should be equals", checkSet.last().data().weight(), players.last().getData().getWeight());
        assertEquals("Heights should be equals", checkSet.last().data().height(), players.last().getData().getHeight());
        assertEquals("Ages should be equals", checkSet.last().data().age(), players.last().getData().getAge());
        assertEquals("Lasts should be equals", checkSet.last().data().last(), players.last().getData().getLast());
    }

    @Test
    void testGetPlayerById() {
        Player novak = getNovak();
        Player playerFetched = service.getPlayerById(52);
        assertTrue("should fetch Novak", novak.equals(playerFetched));
    }

    @Test
    void testFailGetPlayerById() {
        Player novak = getNovak();
        Player playerFetched = service.getPlayerById(95);
        assertFalse("shouldn't fetch Novak", novak.equals(playerFetched));
    }
}
