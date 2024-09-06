package com.emazon.user.domain.spi;

import com.emazon.user.domain.model.User;

import java.util.Optional;

public interface UserPort {

    boolean existByEmail(String email);
}
