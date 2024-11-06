package com.pl.priemer_league.repository;

import com.pl.priemer_league.model.entity.Player;
import com.pl.priemer_league.repository.customrepository.CustomRepositoryPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>, CustomRepositoryPlayer {

    List<Player> findAll();

    Optional<Player> findByPlayerName(String playerName);

    void deleteByPlayerName(String playerName);

    List<Player> findPlayersByTeamName(String TeamName);

    boolean existsByPlayerName(String playerName);

    List<Player> findTopScorers(int limit);
}
