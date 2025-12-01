package com.journal.service;

import com.journal.core.Journal;
import com.journal.dto.UserEvent;

import java.util.List;

public interface JournalService {
    List<Journal> getJournals(String userName);

    void saveUserEvent(UserEvent value);
}
