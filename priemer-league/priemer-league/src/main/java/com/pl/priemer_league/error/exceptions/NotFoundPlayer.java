package com.pl.priemer_league.error.exceptions;

import com.pl.priemer_league.util.timestamp.CurrentTimeStamp;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Value
public class NotFoundPlayer extends Exception {
    Integer code = 54554;
    String message = "Player not found";
    String description;
    Timestamp timestamp;

    public NotFoundPlayer(String description) {
        this.description = description;
        this.timestamp = CurrentTimeStamp.getCurrentTimeStamp();
    }

}
