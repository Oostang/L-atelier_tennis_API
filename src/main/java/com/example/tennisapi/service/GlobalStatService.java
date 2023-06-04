package com.example.tennisapi.service;

import com.example.tennisapi.dto.CountryDto;
import com.example.tennisapi.dto.StatsDto;
import com.example.tennisapi.model.Player;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.NoSuchElementException;
import java.util.SortedSet;

public interface GlobalStatService {
    StatsDto getMisceleannousStats() throws NoSuchElementException;

    CountryDto getWinnerCountry(SortedSet<Player> players);

    double getMeanBMI(DescriptiveStatistics statistics, SortedSet<Player> players);

    int getMedianHeight(DescriptiveStatistics statistics, SortedSet<Player> players);

    double calculateBMI(int weight, short height);
}
