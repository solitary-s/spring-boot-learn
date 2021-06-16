package com.aloneness.spring.boot.kafka.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Message
 *
 * @author tong
 * @date  2020-09-23 上午9:21
 **/
@Data
public class Message implements Serializable {

    private String from;

    private String message;

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public Message(String from, String message) {
        this.from = from;
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
