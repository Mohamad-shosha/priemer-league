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
        if (playerRepository.existsByPlayerName(playerName)) {
            playerRepository.deleteByPlayerName(playerName);
            log.info("Player with name {} was deleted", playerName);
        } else {
            log.warn("Player with name {} does not exist", playerName);
        }
    }

    @Override
    public Optional<Player> findByPlayerName(String playerName) throws NotFoundPlayer {
        Optional<Player> player = playerRepository.findByPlayerName(playerName);
        if (player.isPresent()) {
            return player;
        } else {
            throw new NotFoundPlayer("The player was not found in the database");
        }
    }

    @Override
    public List<Player> findPlayersByTeamName(String teamName) throws NotFoundPlayer {
        List<Player> players = playerRepository.findPlayersByTeamName(teamName);
        if (players.isEmpty()) {
            throw new NotFoundPlayer("No players found for the team");
        } else {
            return players;
        }
    }

    @Override
    public Integer findMatchesPlayedByPlayerName(String playerName) throws NotFoundPlayer {
        findByPlayerName(playerName);
        return playerRepository.getNumberOfMatchesByPlayerName(playerName);
    }

    @Override
    public Double findYellowCardsByPlayerName(String playerName) throws NotFoundPlayer {
        findByPlayerName(playerName);
        return playerRepository.getNumberOfYellowCardsByPlayerName(playerName);
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player updatePlayerStats(String playerName, Player updatedPlayer) throws NotFoundPlayer {
        Player player = findByPlayerName(playerName).orElseThrow(() -> new NotFoundPlayer("Player not found"));
        player.setMatchesPlayed(updatedPlayer.getMatchesPlayed());
        player.setYellowCards(updatedPlayer.getYellowCards());
        player.setGoals(updatedPlayer.getGoals()); // Assuming you have a 'goals' field as well
        return playerRepository.save(player);
    }

    @Override
    public List<Player> findTopScorers(int limit) {
        return playerRepository.findTopScorers(limit);
    }
}
