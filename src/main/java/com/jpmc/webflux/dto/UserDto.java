package com.jpmc.webflux.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@NoArgsConstructor
public class UserDto {

    private Long id;
    @NotBlank(message = "Name should be valid value")
    private String name;

    private String password;
    @NotBlank(message = "date of birthe must be valid value")
    private Date dateOfBirth;
    private String city;
    private String state;
    private String country;
    private String email;
    private Long createdBy;
    private Long updatedBy;
    private Date createdAt;
    private Date updatedAt;

}
