package com.pl.priemer_league.service;

import com.pl.priemer_league.error.exceptions.NotFoundPlayer;
import com.pl.priemer_league.model.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlayerService {
    List<Player> findAll();

    void deleteByPlayerName(String playerName);

    Optional<Player> findByPlayerName(String playerName) throws NotFoundPlayer;

    List<Player> findPlayersByTeamName(String teamName) throws NotFoundPlayer;

}