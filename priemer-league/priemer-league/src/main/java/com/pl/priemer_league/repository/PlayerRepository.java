package com.pl.priemer_league.repository;

import com.pl.priemer_league.model.entity.Player;
import com.pl.priemer_league.repository.customrepository.CustomRepositoryPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing {@link Player} entities.
 * Extends JpaRepository to provide CRUD operations and custom queries for player data.
 * Implements {@link CustomRepositoryPlayer} for additional custom repository methods.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>, CustomRepositoryPlayer {

    /**
     * Retrieves all players.
     *
     * @return a list of all {@link Player} entities.
     */
    List<Player> findAll();

    /**
     * Retrieves a player by their player name.
     *
     * @param playerName the name of the player to retrieve.
     * @return an {@link Optional} containing the {@link Player} if found, otherwise empty.
     */
    Optional<Player> findByPlayerName(String playerName);

    /**
     * Deletes a player by their player name.
     *
     * @param playerName the name of the player to delete.
     */
    void deleteByPlayerName(String playerName);

    /**
     * Retrieves all players belonging to a specific team.
     *
     * @param teamName the name of the team to search for players.
     * @return a list of {@link Player} entities belonging to the specified team.
     */
    List<Player> findPlayersByTeamName(String teamName);

    /**
     * Checks whether a player exists by their player name.
     *
     * @param playerName the name of the player to check for existence.
     * @return true if the player exists, false otherwise.
     */
    boolean existsByPlayerName(String playerName);

    /**
     * Retrieves the top scorers based on a specified limit.
     *
     * @param limit the number of top scorers to retrieve.
     * @return a list of top-scoring {@link Player} entities.
     */
    List<Player> findTopScorers(int limit);
}
