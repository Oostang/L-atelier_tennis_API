package com.example.tennisapi.repository;

import com.example.tennisapi.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.example.tennisapi.util.PlayerGenerator.*;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

    default Optional<SortedSet<Player>> getAll() {
        SortedSet<Player> playerSet = new TreeSet<>(Set.of(getNovak(), getRafael(), getSerena(), getStan(), getVenus()));
        return Optional.of(playerSet);
    }

    default Optional<Player> getById(int id) {
        return switch (id) {
            case 52 -> Optional.of(getNovak());
            case 95 -> Optional.of(getVenus());
            case 65 -> Optional.of(getStan());
            case 102 -> Optional.of(getSerena());
            case 17 -> Optional.of(getRafael());
            default -> Optional.empty();
        };
    }

}
