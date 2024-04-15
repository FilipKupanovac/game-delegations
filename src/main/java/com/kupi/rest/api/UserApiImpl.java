package com.kupi.rest.api;

import com.kupi.rest.api.request.UserRequest;
import com.kupi.rest.dto.UserDTO;
import com.kupi.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiImpl implements UserApi {
    UserService userService;
    @Override
    public UserDTO createUser(UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @Override
    public UserDTO getUser(String uuid) {
        return userService.getUser(uuid);
    }

    @Override
    public void deleteUser(String uuid) {
        userService.deleteUser(uuid);
    }
}
