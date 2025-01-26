package com.pl.priemer_league.controller;

import com.pl.priemer_league.error.exceptions.NotFoundPlayer;
import com.pl.priemer_league.model.entity.Player;
import com.pl.priemer_league.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/PrimerLeague")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    public List<Player> getAllPlayers() {
        return playerService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return ResponseEntity.ok(player);
    }

    @GetMapping("/{playerName}")
    public Player getPlayerByName(@PathVariable String playerName) throws NotFoundPlayer {
        return playerService.findByPlayerName(playerName).orElseThrow(() -> new NotFoundPlayer("Player not found"));
    }

    @GetMapping("/team/{teamName}")
    public List<Player> getPlayersByTeamName(@PathVariable String teamName) throws NotFoundPlayer {
        return playerService.findPlayersByTeamName(teamName);
    }

    @GetMapping("/matches/{playerName}")
    public Integer getNumberOfMatches(@PathVariable String playerName) throws NotFoundPlayer {
        return playerService.findMatchesPlayedByPlayerName(playerName);
    }

    @GetMapping("/ExpectedGoals/{playerName}")
    public double getNumberOfExpectedGoals(@PathVariable String playerName) throws NotFoundPlayer {
        return playerService.getExpectedGoalsToPlayer(playerName);
    }

    @GetMapping("/yellow-cards/{playerName}")
    public Double getNumberOfYellowCards(@PathVariable String playerName) throws NotFoundPlayer {
        return playerService.findYellowCardsByPlayerName(playerName);
    }

    @DeleteMapping("/delete/{playerName}")
    public void delete(@PathVariable String playerName) {
        playerService.deleteByPlayerName(playerName);
    }

    @PutMapping("/{playerName}")
    public ResponseEntity<Player> updatePlayer(@PathVariable String playerName, @RequestBody Player player) throws NotFoundPlayer {
        Player updatedPlayer = playerService.updatePlayerStats(playerName, player);
        return ResponseEntity.ok(updatedPlayer);
    }

}
