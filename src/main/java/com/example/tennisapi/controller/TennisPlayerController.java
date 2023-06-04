package com.example.tennisapi.controller;

import com.example.tennisapi.dto.PlayerDto;
import com.example.tennisapi.dto.StatsDto;
import com.example.tennisapi.mapper.PlayerMapper;
import com.example.tennisapi.service.GlobalStatService;
import com.example.tennisapi.service.PlayerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static com.example.tennisapi.controller.TennisPlayerController.TENNIS;

@RestController
@RequestMapping(TENNIS)
public class TennisPlayerController {

    public static final String TENNIS = "/tennis";
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final PlayerService playerService;

    private final GlobalStatService statService;

    public TennisPlayerController(PlayerService playerService, GlobalStatService statService) {
        this.playerService = playerService;
        this.statService = statService;
    }

    @GetMapping("/getAllPlayers")
    public ResponseEntity<SortedSet<PlayerDto>> getAllPlayers() {
        try {
            return ResponseEntity.ok(
                    playerService.getAllPlayers().stream()
                            .map(PlayerMapper.INSTANCE::toDto)
                            .collect(Collectors.toCollection(TreeSet::new))
            );
        } catch (Exception e) {
            LOGGER.atError().log(e.getStackTrace());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/getPlayerById/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(
                    PlayerMapper.INSTANCE.toDto(playerService.getPlayerById(id))
            );
        } catch (Exception e) {
            LOGGER.atError().log(e.getStackTrace());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/getStats")
    public ResponseEntity<StatsDto> getStats() {
        try {
            return ResponseEntity.ok(statService.getMisceleannousStats());
        } catch (Exception e) {
            LOGGER.atError().log(e.getStackTrace());
            return ResponseEntity.internalServerError().build();
        }

    }

}
