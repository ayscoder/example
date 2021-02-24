package com.ays.example.service;

import com.ays.common.dao.ExampleDao;
import com.ays.common.dao.ExampleNativeQueryDao;
import com.ays.common.dto.ExampleDto;
import com.ays.entities.Example;
import com.ays.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.ays.example.enums.ApiMessage.DELETE_BY_INVALID_EXAMPLE_ID;

/**
 * @author Ayush Agrahari created on 13/01/2021
 */
@Service
@Slf4j
@Transactional
public class ExampleService {

    private final ExampleNativeQueryDao exampleNativeQueryDao;

    private final ExampleDao exampleDao;

    public ExampleService(ExampleNativeQueryDao exampleNativeQueryDao, ExampleDao exampleDao) {
        this.exampleNativeQueryDao = exampleNativeQueryDao;
        this.exampleDao = exampleDao;
    }

    /**
     * Create Example
     *
     * @param reqId requestId
     * @param dto dto
     */
    public void createExample(String reqId, ExampleDto dto) {
        if (dto == null || (dto.getName() == null || dto.getName().equals(""))) {
            throw new BadRequestException(reqId, DELETE_BY_INVALID_EXAMPLE_ID.getCode(), DELETE_BY_INVALID_EXAMPLE_ID.getReason(),
                    DELETE_BY_INVALID_EXAMPLE_ID.getMessage());
        }
        exampleNativeQueryDao.saveExample(ExampleDto.from(dto));
    }

    /**
     * Find all examples
     *
     * @return List of example dto
     */
    public List<ExampleDto> findAllExamples() {
        List<ExampleDto> exampleDtoList = new ArrayList<>();
        for (Example ex : exampleDao.findAll()) {
            exampleDtoList
                    .add(ExampleDto.builder().id(ex.getId()).name(ex.getName()).description(ex.getDescription())
                            .createdOn(ex.getCreatedOn())
                            .updatedOn(ex.getUpdatedOn()).build());
        }
        return exampleDtoList;
    }

    /**
     * Find example by id
     *
     * @param id id
     * @return ExampleDto
     */
    public ExampleDto findExampleById(long id) {
        return ExampleDto.to(exampleNativeQueryDao.getExampleById(id));
    }

    /**
     * Update example by id
     *
     * @param id id
     * @param exampleDto Example dto
     */
    public void updateExampleById(String id, ExampleDto exampleDto) {
        Example existingExample = exampleNativeQueryDao.getExampleById(Long.parseLong(id));
        if (exampleDto.getName() != null) {
            existingExample.setName(exampleDto.getName());
        }
        if (exampleDto.getDescription() != null) {
            existingExample.setDescription(exampleDto.getDescription());
        }
        exampleNativeQueryDao.updateExample(existingExample);
    }

    /**
     * Delete example by id
     *
     * @param id id
     */
    public void deleteExampleById(String id) {
        exampleNativeQueryDao.deleteExample(Long.parseLong(id));
    }
}
