package com.jpmc.webflux.mapper;

import com.jpmc.webflux.dto.UserDto;
import com.jpmc.webflux.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserEntityMapper {

    @Autowired
    private ModelMapper modelMapper;



    public UserDto convertToDto(UserEntity userEntity){
        UserDto userDto = modelMapper.map(userEntity,UserDto.class);
        userDto.setCreatedAt(userEntity.getCreatedAt());
        userDto.setCreatedBy(userEntity.getCreatedBy());
        userDto.setUpdatedAt(userEntity.getUpdatedAt());
        userDto.setUpdatedBy(userDto.getUpdatedBy());
        return userDto;
    }

    public UserEntity convertToEntity(UserDto userDto){

        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userEntity.setCreatedAt(new Date());

        return  userEntity;
    }
}
