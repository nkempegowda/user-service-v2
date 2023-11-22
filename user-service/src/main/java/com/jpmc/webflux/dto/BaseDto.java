package com.jpmc.webflux.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class BaseDto {

    private Long createdBy;
    private Long updatedBy;
    private Date createdAt;
    private Date updatedAt;
}
