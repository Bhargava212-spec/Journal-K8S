package com.journal.service.impl;

import com.google.gson.Gson;
import com.journal.core.Journal;
import com.journal.core.User;
import com.journal.core.repo.JournalRepository;
import com.journal.dto.Event;
import com.journal.dto.UserEvent;
import com.journal.service.JournalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private Gson gson;

    private static final Logger logger = LoggerFactory.getLogger(JournalServiceImpl.class);

    @Override
    public List<Journal> getJournals(String userName) {

        if (Objects.isNull(userName) || userName.isEmpty()) {
            throw new IllegalArgumentException("userName cannot be empty or null");
        }
        List<Journal> journalList = journalRepository.findByUsername(userName);
        logger.info("journals list for the userName : {}", journalList);
        return journalList;
    }

    @Override
    public void saveUserEvent(UserEvent value) {
        Journal journal = new Journal();
        User user = value.getUser();
        journal.setUsername(user.getUsername());
        Event event = new Event();
        event.setEventType(value.getEventType());
        event.setUser(value.getUser());
        journal.setEvent(gson.toJson(event));
        journal.setCreatedDate(new Date());
        journal.setUpdatedDate(new Date());
        journalRepository.save(journal);
        logger.info("Journal details has been saved for the username : {}", user.getUsername());
    }


}
