package com.example.tennisapi.service;

import com.example.tennisapi.model.Player;

import java.util.SortedSet;

public interface PlayerService {

    SortedSet<Player> getAllPlayers();

    Player getPlayerById(int id);

}
