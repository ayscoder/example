package com.ays.example.controller;

import com.ays.common.dto.ExampleDto;
import com.ays.example.service.ExampleService;
import com.ays.util.Constant;
import com.ays.webutil.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ays.example.enums.ApiMessage.*;
import static com.ays.webutil.WebUtils.toResponseEntity;

/**
 * @author user created on 13/01/2021
 */
@RestController
@RequestMapping("/v1/examples")
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ExampleDto>> createExample(@RequestHeader(value = Constant.REQUEST_ID) String requestId,
            @RequestBody ExampleDto dto) {
        exampleService.createExample(requestId, dto);
        return toResponseEntity(new ApiResponse.Builder<ExampleDto>(HttpStatus.OK, requestId,
                EXAMPLE_SAVED.getCode(), EXAMPLE_SAVED.getReason(), EXAMPLE_SAVED.getMessage()).build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ExampleDto>>> findAllExample(@RequestHeader(value = Constant.REQUEST_ID) String requestId) {
        List<ExampleDto> allExamples = exampleService.findAllExamples();
        return toResponseEntity(new ApiResponse.Builder<List<ExampleDto>>(HttpStatus.OK, requestId,
                EXAMPLE_FIND.getCode(), EXAMPLE_FIND.getReason(), EXAMPLE_FIND.getMessage()).withData(allExamples).build());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<ExampleDto>> findAllExample(@RequestHeader(value = Constant.REQUEST_ID) String requestId, @PathVariable(value = "id") String id) {
        ExampleDto example = exampleService.findExampleById(Long.parseLong(id));
        return toResponseEntity(new ApiResponse.Builder<ExampleDto>(HttpStatus.OK, requestId,
                EXAMPLE_FIND_BYI_D.getCode(), EXAMPLE_FIND_BYI_D.getReason(), EXAMPLE_FIND_BYI_D.getMessage()).withData(example).build());
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<Void>> updateExample(@RequestHeader(value = Constant.REQUEST_ID) String requestId, @RequestBody ExampleDto exampleDto, @PathVariable String id) {
        exampleService.updateExampleById(id, exampleDto);
        return toResponseEntity(new ApiResponse.Builder<Void>(HttpStatus.OK, requestId,
                EXAMPLE_UPDATE_BYI_D.getCode(), EXAMPLE_UPDATE_BYI_D.getReason(), EXAMPLE_UPDATE_BYI_D.getMessage()).build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteExample(@RequestHeader(value = Constant.REQUEST_ID) String requestId, @PathVariable String id) {
        exampleService.deleteExampleById(id);
        return toResponseEntity(new ApiResponse.Builder<Void>(HttpStatus.OK, requestId,
                EXAMPLE_UPDATE_BYI_D.getCode(), EXAMPLE_UPDATE_BYI_D.getReason(), EXAMPLE_UPDATE_BYI_D.getMessage()).build());
    }
}
