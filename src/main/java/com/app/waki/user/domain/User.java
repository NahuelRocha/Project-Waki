package com.app.waki.user.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@ToString
public class User {

    @Id
    private  UserId userId;
    @Embedded
    private  UserName userName;
    @Embedded
    private  Email email;
    @Embedded
    private  Password password;
    @Enumerated(EnumType.STRING)
    private  UserRole role;

    public User(){}
    public User (UserName userName, Email email, Password password, UserRole userRole) {
        this.userId = new UserId();
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = userRole;
    }

    public static User createUser(String userName, String email, String password){
        var username = new UserName(userName);
        var userEmail = new Email(email);
        var userPassword = new Password(password);
        return new User(username, userEmail, userPassword, UserRole.USER);
    }
    public String getId(){
        return this.userId.id().toString();
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
    public String getUsername(){ return this.userName.name(); }

}
