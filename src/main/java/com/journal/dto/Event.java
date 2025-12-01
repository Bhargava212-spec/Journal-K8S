package com.journal.dto;

import com.journal.core.User;
import lombok.Data;

@Data
public class Event {

    private User user;
    private EventType eventType;
}
