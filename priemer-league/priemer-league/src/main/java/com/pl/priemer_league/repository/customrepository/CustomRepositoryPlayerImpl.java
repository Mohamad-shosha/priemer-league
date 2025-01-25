package com.pl.priemer_league.repository.customrepository;

import com.pl.priemer_league.error.exceptions.NotFoundPlayer;
import com.pl.priemer_league.model.entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class CustomRepositoryPlayerImpl implements CustomRepositoryPlayer {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Player> getPlayersFromTeamName(String teamName) {
        String sql = "SELECT p FROM Player p WHERE p.teamName = :teamName";
        Query query = entityManager.createQuery(sql);
        query.setParameter("teamName", teamName);
        return query.getResultList();
    }

    @Override
    public List<Player> getPlayersOfLeague() {
        String sql = "SELECT p FROM Player p";
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public Integer getNumberOfMatchesByPlayerName(String playerName) throws NotFoundPlayer {
        String sql = "SELECT p.matchesPlayed FROM Player p WHERE p.playerName = :playerName";
        Query query = entityManager.createQuery(sql);
        query.setParameter("playerName", playerName);

        Integer matchesPlayed = (Integer) query.getSingleResult();
        if (matchesPlayed == null) {
            throw new NotFoundPlayer("Player not found: " + playerName);
        }
        return matchesPlayed;
    }

    @Override
    public Double getNumberOfYellowCardsByPlayerName(String playerName) throws NotFoundPlayer {
        String sql = "SELECT p.yellowCards FROM Player p WHERE p.playerName = :playerName";
        Query query = entityManager.createQuery(sql);
        query.setParameter("playerName", playerName);

        Double yellowCards = (Double) query.getSingleResult();
        if (yellowCards == null) {
            throw new NotFoundPlayer("Player not found: " + playerName);
        }
        return yellowCards;
    }

    @Override
    public Player getPlayerStatsByName(String playerName) {
        String sql = "SELECT p FROM Player p WHERE p.playerName = :playerName";
        Query query = entityManager.createQuery(sql);
        query.setParameter("playerName", playerName);
        return (Player) query.getSingleResult();
    }

    @Override
    public Double getAverageYellowCardsInLeague() {
        String sql = "SELECT AVG(p.yellowCards) FROM Player p";
        Query query = entityManager.createQuery(sql);
        return (Double) query.getSingleResult();
    }

    @Override
    public List<Player> getTopPlayersByMatches(int limit) {
        String sql = "SELECT p FROM Player p ORDER BY p.matchesPlayed DESC";
        Query query = entityManager.createQuery(sql);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public double findExpectedGoalsByPlayerName(String playerName) throws NotFoundPlayer {
        String sql = "SELECT p.expectedGoals FROM Player p WHERE p.playerName = :playerName";
        Query query = entityManager.createQuery(sql);
        query.setParameter("playerName", playerName);
        Double expectedGoals = (Double) query.getSingleResult();
        if (expectedGoals == null) {
            throw new NotFoundPlayer("Player not found: " + playerName);
        } else {
            return expectedGoals;
        }
    }

}
