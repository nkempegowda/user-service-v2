package com.jpmc.webflux.service.impl;

import com.jpmc.webflux.dao.UserDao;
import com.jpmc.webflux.dto.UserDto;
import com.jpmc.webflux.entity.UserEntity;
import com.jpmc.webflux.mapper.UserEntityMapper;
import com.jpmc.webflux.repository.UserRepository;
import com.jpmc.webflux.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Flux<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public Mono<UserDto> getUser(Long userId) {

       return userDao.getUser(userId);
    }
}
