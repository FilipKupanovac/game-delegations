package com.kupi.service;

import com.kupi.persistence.entity.UserEntity;
import com.kupi.persistence.repository.UserRepository;
import com.kupi.rest.api.request.UserRequest;
import com.kupi.rest.dto.UserDTO;
import com.kupi.service.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final IdGenerator idGenerator;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, IdGenerator idGenerator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.idGenerator = idGenerator;
    }

    @Override
    public UserDTO createUser(UserRequest userRequest) {
        UserEntity user = userMapper.toEntity(userRequest);
        user.setUuid(idGenerator.generateId().toString());
        user.setGrantedAuthorities(
                userRequest.getUserRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(String.format("ROLE_%s", role.toUpperCase())))
                        .collect(Collectors.toList())
        );
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO getUser(String uuid) {
        return userMapper.toDTO(getUserByUuid(uuid));
    }

    @Override
    public void deleteUser(String uuid) {
        userRepository.delete(getUserByUuid(uuid));
    }

    private UserEntity getUserByUuid(String uuid) {
        return userRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("User with uuid " + uuid + " not found"));
    }
}
