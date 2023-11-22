package com.jpmc.webflux.dao.impl;

import com.jpmc.webflux.dao.UserDao;
import com.jpmc.webflux.dto.UserDto;
import com.jpmc.webflux.entity.UserEntity;
import com.jpmc.webflux.mapper.UserEntityMapper;
import com.jpmc.webflux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Flux<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public Mono<UserDto> getUser(Long userId) {
        Mono<UserEntity> userEntityMono = userRepository.findById(userId);
        //  userEntityMono.subscribe(userEntity -> {});
        return userEntityMono.map(userEntityMapper::convertToDto);
        // return null;
    }
}
