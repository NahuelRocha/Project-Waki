package com.app.waki.user.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@ToString
public class User {

    @Id
    private final UserId userId;
    @Embedded
    private final UserName userName;
    @Embedded
    private final Email email;
    @Embedded
    private final Password password;
    @Enumerated(EnumType.STRING)
    private final UserRole role;

    public User (UserName userName, Email email, Password password, UserRole userRole) {
        this.userId = new UserId();
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = userRole;
    }

    public String getRole(){
        return this.role.name();
    }
    public String getEmail(){
        return this.email.email();
    }
    public String getPassword(){
        return this.password.password();
    }

}
