package com.journal.core.repo;

import com.journal.core.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<Journal,Long> {
    List<Journal> findByUsername(String username);

}
