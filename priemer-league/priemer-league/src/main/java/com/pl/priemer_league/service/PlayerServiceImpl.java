package com.pl.priemer_league.service;

import com.pl.priemer_league.error.exceptions.NotFoundPlayer;
import com.pl.priemer_league.model.entity.Player;
import com.pl.priemer_league.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public void deleteByPlayerName(String playerName) {
        playerRepository.deleteByPlayerName(playerName);
    }

    @Override
    public Optional<Player> findByPlayerName(String playerName) throws NotFoundPlayer {
        Optional<Player> player = playerRepository.findByPlayerName(playerName);
        if (player.isPresent()) {
            log.info("Player with name {} was found", playerName);
            return player;
        } else {
            log.info("Player with name {} was not found", playerName);
            throw new NotFoundPlayer("The player with not found in the database");
        }
    }

    @Override
    public List<Player> findPlayersByTeamName(String teamName) throws NotFoundPlayer {
        List<Player> players = playerRepository.findPlayersByTeamName(teamName);
        if (players.isEmpty()) {
            log.info("Players with name {} was not found", teamName);
            throw new NotFoundPlayer("No players to display with this team");
        } else {
            log.info("Players with name {} found", teamName);
            return players;
        }
    }
}
