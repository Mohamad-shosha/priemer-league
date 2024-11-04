package com.pl.priemer_league.error.body;

import com.pl.priemer_league.util.timestamp.CurrentTimeStamp;
import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;

@Builder
public record ErrorResponse(Integer code, String message, String details, Timestamp timestamp) {
    public ErrorResponse(Integer code, String message, String details, Timestamp timestamp) {
        this.code = code;
        this.message = message;
        this.details = details;
        this.timestamp = CurrentTimeStamp.getCurrentTimeStamp();
    }
}
