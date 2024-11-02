package com.pl.priemer_league.controller;

import com.pl.priemer_league.error.exceptions.NotFoundPlayer;
import com.pl.priemer_league.model.entity.Player;
import com.pl.priemer_league.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService1) {
        this.playerService = playerService1;
    }

    @GetMapping("/Players")
    public List<Player> getAllPlayers() {
        return playerService.findAll();
    }

    @DeleteMapping("/delete/{playerName}")
    public void delete(@PathVariable String playerName) {
        playerService.deleteByPlayerName(playerName);
        log.info("Deleted player " + playerName);
    }

    @GetMapping("/players/{playerName}")
    public List<Player> getPlayersByTeamName(@PathVariable String playerName) throws NotFoundPlayer {
        return playerService.findPlayersByTeamName(playerName);
    }


}
