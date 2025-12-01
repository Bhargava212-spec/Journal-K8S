package com.journal.dto;

import com.journal.core.User;
import lombok.Data;

import java.util.Date;
@Data
public class UserEvent {
    private User user;
    private EventType eventType;
    private Date date;
}
