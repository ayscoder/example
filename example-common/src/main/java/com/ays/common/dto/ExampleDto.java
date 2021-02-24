package com.ays.common.dto;

import com.ays.entities.Example;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Calendar;

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
    private String createdOn;
    private String updatedOn;

    public static Example from(ExampleDto dto) {
        Example example = new Example();
        example.setName(dto.getName());
        example.setDescription(dto.getDescription());
        example.setCreatedOn(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        example.setUpdatedOn(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        return example;
    }

    public static ExampleDto to(Example example) {
        ExampleDto exampleDto = new ExampleDto();
        exampleDto.setId(example.getId());
        exampleDto.setName(example.getName());
        exampleDto.setDescription(example.getDescription());
        exampleDto.setCreatedOn(example.getCreatedOn());
        exampleDto.setUpdatedOn(example.getUpdatedOn());
        return exampleDto;
    }
}
