package com.pl.priemer_league.repository.customrepository;

import com.pl.priemer_league.error.exceptions.NotFoundPlayer;
import com.pl.priemer_league.model.entity.Player;

import java.util.List;

public interface CustomRepositoryPlayer {
    List<Player> getPlayersFromTeamName(String teamName);

    List<Player> getPlayersOfLeague();

    Integer getNumberOfMatchesByPlayerName(String playerName)throws NotFoundPlayer;
}
