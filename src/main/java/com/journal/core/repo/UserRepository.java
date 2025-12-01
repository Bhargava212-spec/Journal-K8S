package com.journal.core.repo;

import com.journal.core.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndEnabled(String email, boolean enabled);


    User findByUsername(String userName);

    User findByEmail(String email);
}
