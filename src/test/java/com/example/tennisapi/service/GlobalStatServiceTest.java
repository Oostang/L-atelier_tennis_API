package com.example.tennisapi.service;

import com.example.tennisapi.dto.CountryDto;
import com.example.tennisapi.model.Country;
import com.example.tennisapi.model.Player;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static com.example.tennisapi.util.PlayerGenerator.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class GlobalStatServiceTest {

    @Autowired
    public GlobalStatService statService;

    @Test
    void testGetWinnerByCountry() {
        SortedSet<Player> players = new TreeSet<>(
                List.of(getRafael(), getNovak(), getSerena(), getStan(), getVenus(), getRick(), getYannick(), getLeroy()));
        CountryDto winner = statService.getWinnerCountry(players);

        assertEquals(
                "Countries' url should be equals",
                new CountryDto("https://youtu.be/dQw4w9WgXcQ", "POL").picture(),
                winner.picture()
        );
        assertEquals("Countries' code should be equals",
                new Country("https://youtu.be/dQw4w9WgXcQ",
                        "POL").getCode(), winner.code()
        );
    }

    @Test
    void testGetMeanBMI() {
        SortedSet<Player> players = new TreeSet<>(
                Set.of(getRafael(), getNovak(), getSerena(), getStan(), getVenus(), getRick(), getYannick(), getLeroy()));
        double avgBMI = statService.getMeanBMI(new DescriptiveStatistics(), players);
        assertEquals("average BMI is 22.13", 22.13, avgBMI);
    }

    @Test
    void testGetMedianHeight() {
        SortedSet<Player> players = new TreeSet<>(
                Set.of(getRafael(), getNovak(), getSerena(), getStan(), getVenus(), getRick(), getYannick(), getLeroy()));
        int median = statService.getMedianHeight(new DescriptiveStatistics(), players);
        assertEquals("Median height is 185", 185, median);
    }
}
