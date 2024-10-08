package com.app.waki.user.infrastructure;

import com.app.waki.user.domain.Email;
import com.app.waki.user.domain.User;
import com.app.waki.user.domain.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface JpaUserDataRepository extends JpaRepository<User, UserId> {
    Optional<User> findByEmail(Email email);
}
