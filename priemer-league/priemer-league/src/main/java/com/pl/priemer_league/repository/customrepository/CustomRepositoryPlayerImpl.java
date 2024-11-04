package com.pl.priemer_league.repository.customrepository;

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
    public Integer getNumberOfMatchesByPlayerName(String playerName) {
        String sql = "SELECT p.matchesPlayed FROM Player p WHERE p.playerName = :playerName";
        Query query = entityManager.createQuery(sql);
        query.setParameter("playerName", playerName);
        return (Integer) query.getSingleResult();
    }
}
