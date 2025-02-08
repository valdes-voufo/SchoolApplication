package com.ydova.schoolapp.server.repository;

import com.ydova.schoolapp.server.entity.User;

public class UserRepository extends YRepository<User, Long> {
    public UserRepository() {
        super(User.class);
    }

}
