package com.emazon.user.domain.api.usecase;

import com.emazon.user.domain.api.IUserServicePort;
import com.emazon.user.domain.model.User;
import com.emazon.user.domain.spi.UserRegisterPort;

public class UserUseCase implements IUserServicePort {
    private final UserRegisterPort userRegisterPort;

    public UserUseCase(UserRegisterPort userRegisterPort){
        this.userRegisterPort = userRegisterPort;
    }


    @Override
    public void registerUser(User user) {
        // validation, business rules
        userRegisterPort.registerUser(user);
    }
}
