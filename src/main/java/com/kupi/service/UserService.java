package com.kupi.service;

import com.kupi.rest.api.request.UserRequest;
import com.kupi.rest.dto.UserDTO;

/**
 * Service to handle application users
 */
public interface UserService {
    /**
     * Creates new application user based on given request.
     *
     * @param userRequest request
     * @return created user representation
     */
    UserDTO createUser(UserRequest userRequest);

    /**
     * Retrieve user based on uuid.
     *
     * @param uuid user identifier
     * @return user representation
     */
    UserDTO getUser(String uuid);

    /**
     * Delete user based on uuid.
     *
     * @param uuid user identifier
     */
    void deleteUser(String uuid);
}
