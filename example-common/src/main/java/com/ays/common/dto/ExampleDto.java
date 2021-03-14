package com.ays.common.dto;

import com.ays.entities.Example;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @author user created on 13/01/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExampleDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String createdTime;
    private String lastModifiedTime;

    public static Example from(ExampleDto dto) {
        Example example = new Example();
        example.setName(dto.getName());
        example.setDescription(dto.getDescription());
        example.setCreatedTime(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        example.setLastModifiedTime(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        return example;
    }

    public static ExampleDto to(Example example) {
        ExampleDto exampleDto = new ExampleDto();
        exampleDto.setId(example.getId());
        exampleDto.setName(example.getName());
        exampleDto.setDescription(example.getDescription());
        exampleDto.setCreatedTime(example.getCreatedTime());
        exampleDto.setLastModifiedTime(example.getLastModifiedTime());
        return exampleDto;
    }
}
