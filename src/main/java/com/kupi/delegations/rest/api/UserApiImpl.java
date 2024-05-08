package com.kupi.delegations.rest.api;

import com.kupi.delegations.rest.api.request.UserRequest;
import com.kupi.delegations.rest.dto.UserDTO;
import com.kupi.delegations.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiImpl implements UserApi {
    private static Logger log = LoggerFactory.getLogger(AssignmentApiImpl.class);

    private final UserService userService;

    public UserApiImpl(UserService userService) {
        this.userService = userService;
        log.info(this.getClass().getName() + " successfully initialized");
    }

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
