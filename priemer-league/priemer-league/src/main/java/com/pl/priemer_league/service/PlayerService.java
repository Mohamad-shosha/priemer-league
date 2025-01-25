package com.pl.priemer_league.service;

import com.pl.priemer_league.error.exceptions.NotFoundPlayer;
import com.pl.priemer_league.model.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlayerService {

    /**
     * Retrieves all players from the database.
     *
     * @return a list of all players.
     */
    List<Player> findAll();

    /**
     * Deletes a player based on their player name.
     *
     * @param playerName the name of the player to be deleted.
     */
    void deleteByPlayerName(String playerName);

    /**
     * Finds a player by their player name.
     *
     * @param playerName the name of the player to be found.
     * @return an Optional containing the player if found, or an empty Optional if not.
     * @throws NotFoundPlayer if no player is found with the given name.
     */
    Optional<Player> findByPlayerName(String playerName) throws NotFoundPlayer;

    /**
     * Retrieves a list of players who belong to a specific team.
     *
     * @param teamName the name of the team whose players need to be fetched.
     * @return a list of players belonging to the specified team.
     * @throws NotFoundPlayer if no players are found for the given team.
     */
    List<Player> findPlayersByTeamName(String teamName) throws NotFoundPlayer;

    /**
     * Retrieves the number of matches played by a player based on their name.
     *
     * @param playerName the name of the player whose matches are to be retrieved.
     * @return the number of matches played by the player.
     * @throws NotFoundPlayer if the player with the given name is not found.
     */
    Integer findMatchesPlayedByPlayerName(String playerName) throws NotFoundPlayer;

    /**
     * Retrieves the number of yellow cards received by a player based on their name.
     *
     * @param playerName the name of the player whose yellow cards are to be retrieved.
     * @return the number of yellow cards received by the player.
     * @throws NotFoundPlayer if the player with the given name is not found.
     */
    Double findYellowCardsByPlayerName(String playerName) throws NotFoundPlayer;

    /**
     * Saves a new player to the database.
     *
     * @param player the player entity to be saved.
     */
    void savePlayer(Player player);

    /**
     * Updates the stats (matches played and yellow cards) of an existing player.
     *
     * @param playerName    the name of the player whose stats are to be updated.
     * @param updatedPlayer the player entity containing the updated stats.
     * @return the updated player entity after saving the changes.
     * @throws NotFoundPlayer if the player with the given name is not found.
     */
    Player updatePlayerStats(String playerName, Player updatedPlayer) throws NotFoundPlayer;

    /**
     * Retrieves the top scorers from the league based on the number of goals scored.
     *
     * @param limit the maximum number of top scorers to retrieve.
     * @return a list of players who are the top scorers in the league.
     */
    List<Player> findTopScorers(int limit);

    double getExpectedGoalsToPlayer(String playerName) throws NotFoundPlayer;
}
