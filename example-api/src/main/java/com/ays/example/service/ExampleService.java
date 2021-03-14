package com.ays.example.service;

import com.ays.common.dao.ExampleNativeQueryDao;
import com.ays.common.dto.ExampleDto;
//import com.ays.encrypt.PasswordEncryptor;
import com.ays.entities.Example;
import com.ays.exception.BadRequestException;
import com.ays.util.RestTemplateHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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

    private final RestTemplateHelper restTemplateHelper;

    private final ExampleNativeQueryDao exampleNativeQueryDao;

    public ExampleService(ExampleNativeQueryDao exampleNativeQueryDao, RestTemplateHelper restTemplateHelper) {//}, RestTemplateBuilder builder) {
        this.exampleNativeQueryDao = exampleNativeQueryDao;
        this.restTemplateHelper = restTemplateHelper;
    }

    /**
     * Create Example
     *
     * @param reqId requestId
     * @param dto   dto
     */
    public Example createExample(String reqId, ExampleDto dto) {
        if (dto == null || (dto.getName() == null || dto.getName().equals(""))) {
            throw new BadRequestException(reqId, DELETE_BY_INVALID_EXAMPLE_ID.getCode(), DELETE_BY_INVALID_EXAMPLE_ID.getReason(),
                    DELETE_BY_INVALID_EXAMPLE_ID.getMessage());
        }
        Example example = exampleNativeQueryDao.saveExample(ExampleDto.from(dto));
        return example;
    }



    /**
     * Find all examples
     *
     * @return List of example dto
     */
    public List<ExampleDto> findAllExamples() {
        //        String forObject = restTemplate.getForObject("https://reqres.in/api/users?page=2", String.class);
        //        log.info("## forObject: {}", forObject);
//        String forEntity = restTemplateHelper.getForEntity(String.class, "https://reqres.in/api/users/2");
//        log.info("## forObject: {}", forEntity);

        //        String password = "yawinpassword";
        //        String encodedPassword = passwordEncryptor.encodePassword(password);
        //        log.info("## Password is         : " + password);
        //        log.info("## Encoded Password is : " + encodedPassword);
        //
        //        boolean isPasswordMatch = passwordEncryptor.matchPassword(password, encodedPassword);
        //        log.info("## Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
        //
        //        password = "yawin";
        //        isPasswordMatch = passwordEncryptor.matchPassword(password, encodedPassword);
        //        log.info("## Password : " + password + "           isPasswordMatch    : " + isPasswordMatch);

        List<ExampleDto> exampleDtoList = new ArrayList<>();
        List<Example> all = exampleNativeQueryDao.getAllExamples();
        for (Example ex : all) {
            exampleDtoList
                    .add(ExampleDto.builder().id(ex.getId()).name(ex.getName()).description(ex.getDescription())
                            .createdTime(ex.getCreatedTime())
                            .lastModifiedTime(ex.getLastModifiedTime()).build());
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
     * @param id         id
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
