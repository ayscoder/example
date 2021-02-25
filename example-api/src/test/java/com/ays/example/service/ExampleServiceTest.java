package com.ays.example.service;

import com.ays.common.dao.ExampleDao;
import com.ays.common.dao.ExampleNativeQueryDao;
import com.ays.common.dto.ExampleDto;
import com.ays.exception.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

/**
 * @author ayush created on 25/02/2021
 */
public class ExampleServiceTest {

    @InjectMocks
    private ExampleService exampleService;

    @Mock
    ExampleNativeQueryDao exampleNativeQueryDao;

    @Mock
    ExampleDao exampleDao;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createExample() {
        ExampleDto exampleDto = new ExampleDto();
        exampleDto.setName("name1");
        exampleDto.setDescription("description1");
        exampleService.createExample("r1", exampleDto);
    }

    @Test
    public void createExampleWhenExampleDtoNull() {
        BadRequestException badRequestException = Assertions.assertThrows(BadRequestException.class, () -> {
            exampleService.createExample("r1", null);
        });
        Assertions.assertEquals("r1", badRequestException.getRequestId());
    }

}
