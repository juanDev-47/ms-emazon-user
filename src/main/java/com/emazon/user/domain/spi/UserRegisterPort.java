package com.emazon.user.domain.spi;

import com.emazon.user.domain.model.User;

public interface UserRegisterPort {

    void registerUser(User user);
}
