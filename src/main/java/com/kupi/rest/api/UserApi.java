package com.kupi.rest.api;

import com.kupi.rest.api.request.UserRequest;
import com.kupi.rest.dto.UserDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/public/users")
public interface UserApi {

    @PostMapping
    UserDTO createUser(@RequestBody UserRequest userRequest);

    @GetMapping("/{uuid}")
    UserDTO getUser(@PathVariable String uuid);


    @DeleteMapping("/{uuid}")
    void deleteUser(@PathVariable String uuid);
}
