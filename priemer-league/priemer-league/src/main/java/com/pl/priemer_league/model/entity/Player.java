package com.pl.priemer_league.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "player_statistic")
public class Player {
    @Id
    @Column(name = "player_name", unique = true, nullable = false)
    private String playerName;
    private String nation;
    private String position;
    private Integer age;
    @Column(name = "matches_played")
    private Integer matchesPlayed;
    private Double goals;
    private Double assists;
    @Column(name = "penalties_scored")
    private Double penaltiesScored;
    @Column(name = "yellow_cards")
    private Double yellowCards;
    @Column(name = "red_cards")
    private Double redCards;
    @Column(name = "expected_goals")
    private Double expectedGoals;
    @Column(name = "expected_assists")
    private Double expectedAssists;
    @Column(name = "team_name")
    private String teamName;
}
