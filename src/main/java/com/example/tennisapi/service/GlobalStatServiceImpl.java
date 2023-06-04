package com.example.tennisapi.service;

import com.example.tennisapi.dto.CountryDto;
import com.example.tennisapi.dto.StatsDto;
import com.example.tennisapi.mapper.CountryMapper;
import com.example.tennisapi.model.Player;
import com.example.tennisapi.repository.PlayerRepository;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.math3.util.Precision.round;

@Service
public class GlobalStatServiceImpl implements GlobalStatService {

    private final PlayerRepository repository;

    public GlobalStatServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public StatsDto getMisceleannousStats() throws NoSuchElementException {
        SortedSet<Player> players = repository.getAll().orElseThrow();
        DescriptiveStatistics statistics = new DescriptiveStatistics();
        return new StatsDto(getWinnerCountry(players), getMeanBMI(statistics, players), getMedianHeight(statistics, players));
    }

    @Override
    public CountryDto getWinnerCountry(SortedSet<Player> players) {
        Map<String, Integer> pointPerCountry = new HashMap<>();

        players.stream().forEach(player -> {
            int previousPoint;
                    if (pointPerCountry.containsKey(player.getCountry().getCode())) {
                        previousPoint = pointPerCountry.get(player.getCountry().getCode());
                        pointPerCountry.replace(
                                player.getCountry().getCode(),
                                previousPoint + player.getData().getPoints()
                        );
                    } else {
                        pointPerCountry.put(player.getCountry().getCode(), player.getData().getPoints());
                    }
                }
        );

        Optional<Map.Entry<String, Integer>> op = pointPerCountry.entrySet().stream().max(Map.Entry.comparingByValue());
        String winnerCountryCode = op.isPresent() ? op.get().getKey() : "";
        return players.stream()
                .filter(player -> player.getCountry().getCode().equals(winnerCountryCode))
                .findFirst().map(player -> CountryMapper.INSTANCE.toDto(player.getCountry()))
                .orElseThrow();
    }

    @Override
    public double getMeanBMI(DescriptiveStatistics statistics, SortedSet<Player> players) {
        players.forEach(
                player -> statistics.addValue(
                        calculateBMI(player.getData().getWeight(), player.getData().getHeight())
                )
        );
        double meanBMI = round(statistics.getMean(), 2);
        statistics.clear();
        return meanBMI;
    }

    @Override
    public int getMedianHeight(DescriptiveStatistics statistics, SortedSet<Player> players) {
        players.forEach(player -> statistics.addValue(player.getData().getHeight()));
        int median = (int) statistics.getPercentile(50);
        statistics.clear();
        return median;
    }

    @Override
    public double calculateBMI(int weight, short height) {
        double weightInD = weight / 10d;
        double heightInD = height / 10d;
        return weightInD / (heightInD * heightInD);
    }
}
