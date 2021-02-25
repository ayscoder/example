package com.ays.example.controller;

import com.ays.common.dto.ExampleDto;
import com.ays.example.service.ExampleService;
import com.ays.webutil.ApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @author ayush created on 25/02/2021
 */
public class ExampleControllerTest {

    @InjectMocks
    private ExampleController exampleController;

    @Mock
    ExampleService exampleService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createExample() {
        ExampleDto exampleDto = new ExampleDto();
        exampleDto.setName("name1");
        exampleDto.setDescription("description1");
        exampleController.createExample("r1", exampleDto);
    }

    @Test
    public void findAllExample() {
        ExampleDto exampleDto = new ExampleDto();
        exampleDto.setName("name1");
        exampleDto.setDescription("description1");
        List<ExampleDto> allExamples = new ArrayList<>();
        allExamples.add(exampleDto);
        when(exampleService.findAllExamples()).thenReturn(allExamples);
        ResponseEntity<ApiResponse<List<ExampleDto>>> r1 = exampleController.findAllExample(null);
        Assertions.assertEquals(200, r1.getStatusCodeValue());
    }
}
