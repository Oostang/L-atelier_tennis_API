package com.example.tennisapi.service;

import com.example.tennisapi.model.Player;
import com.example.tennisapi.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.SortedSet;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository repository;

    public PlayerServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public SortedSet<Player> getAllPlayers() throws NoSuchElementException {
        return repository.getAll().orElseThrow();
    }

    @Override
    public Player getPlayerById(int id) throws NoSuchElementException {
        return repository.getById(id).orElseThrow();
    }
}
