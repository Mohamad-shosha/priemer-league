package com.pl.priemer_league.repository.customrepository;

import com.pl.priemer_league.error.exceptions.NotFoundPlayer;
import com.pl.priemer_league.model.entity.Player;

import java.util.List;
import java.util.Optional;

public interface CustomRepositoryPlayer {
    /**
     * Retrieves a list of players from a specific team.
     *
     * @param teamName The name of the team.
     * @return A list of players from the specified team.
     */
    List<Player> getPlayersByTeamName(String teamName);

    /**
     * Retrieves a list of all players in the league.
     *
     * @return A list of all players in the league.
     */
    List<Player> getPlayersOfLeague();

    /**
     * Retrieves the number of matches played by a specific player.
     *
     * @param playerName The name of the player.
     * @return The number of matches played by the player.
     * @throws NotFoundPlayer If the player is not found.
     */
    Integer getNumberOfMatchesByPlayerName(String playerName) throws NotFoundPlayer;

    /**
     * Retrieves the number of yellow cards received by a specific player.
     *
     * @param playerName The name of the player.
     * @return The number of yellow cards received by the player.
     * @throws NotFoundPlayer If the player is not found.
     */
    Double getNumberOfYellowCardsByPlayerName(String playerName) throws NotFoundPlayer;

    /**
     * Retrieves the average number of yellow cards across all players in the league.
     *
     * @return The average number of yellow cards in the league.
     */
    Double getAverageYellowCardsInLeague();

    /**
     * Retrieves the top players in terms of the number of matches played.
     *
     * @param limit The number of top players to return.
     * @return A list of top players sorted by matches played in descending order.
     */
    List<Player> getTopPlayersByMatches(int limit);

    double findExpectedGoalsByPlayerName(String playerName) throws NotFoundPlayer;

}
