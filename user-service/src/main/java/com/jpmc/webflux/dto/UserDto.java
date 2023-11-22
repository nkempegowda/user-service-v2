package com.jpmc.webflux.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class UserDto extends BaseDto{

    private Long id;
    private String name;
    private String password;
    private Date dateOfBirth;
    private String city;
    private String state;
    private String country;
    private String email;

}
