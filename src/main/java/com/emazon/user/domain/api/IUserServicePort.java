package com.emazon.user.domain.api;

import com.emazon.user.domain.model.User;

import java.util.Optional;

public interface IUserServicePort {
    boolean existByEmail(String email);
}
