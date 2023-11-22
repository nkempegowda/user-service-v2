package com.jpmc.webflux.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Setter
@Getter
@Table(name = "users")
public class UserEntity {
//createdBy | createdAt           | updatedBy | updatedAt
    @Id
    private Long id;
    private String name;
    private String password;
    private Date dateOfBirth;
    private String city;
    private String state;
    private String country;
    private String email;
    @Column("createdBy")
    private Long createdBy;
    @Column("updatedBy")
    private Long updatedBy;
    @Column("createdAt")
    private Date createdAt;
    @Column("updatedAt")
    private Date updatedAt;



}
