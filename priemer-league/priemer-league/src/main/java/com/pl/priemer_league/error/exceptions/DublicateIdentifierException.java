package com.pl.priemer_league.error.exceptions;

import com.pl.priemer_league.util.timestamp.CurrentTimeStamp;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.hibernate.HibernateException;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Value
public class DublicateIdentifierException extends HibernateException {
    Integer code = 4565;
    String msg = "Dublicate identifier exception";
    Timestamp timestamp;

    public DublicateIdentifierException(String message) {
        super(message);
        this.timestamp = CurrentTimeStamp.getCurrentTimeStamp();
    }
}
