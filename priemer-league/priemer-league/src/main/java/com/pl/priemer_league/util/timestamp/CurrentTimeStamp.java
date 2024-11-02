package com.pl.priemer_league.util.timestamp;

import java.sql.Timestamp;

public class CurrentTimeStamp {
    private CurrentTimeStamp() {

    }

    public static Timestamp getCurrentTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
