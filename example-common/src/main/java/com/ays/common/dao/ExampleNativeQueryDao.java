package com.ays.common.dao;

import com.ays.common.dto.mapper.ExampleMapper;
import com.ays.entities.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ExampleNativeQueryDao {

    private final JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_EXAMPLE = "select * from example where id = ?";
    private final String SQL_DELETE_EXAMPLE = "delete from example where id = ?";
    private final String SQL_UPDATE_Example = "update example set name = ?, description = ? where id = ?";
    private final String SQL_GET_ALL = "select * from example";
    private final String SQL_INSERT_EXAMPLE = "insert into example(name, description, createdOn, updatedOn) values(?,?,?,?)";

    @Autowired
    public ExampleNativeQueryDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Example getExampleById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_EXAMPLE, new Object[] { id }, new ExampleMapper());
    }

    public List<Example> getAllExamples() {
        return jdbcTemplate.query(SQL_GET_ALL, new ExampleMapper());
    }

    public void deleteExample(Long id) {
        jdbcTemplate.update(SQL_DELETE_EXAMPLE, id);
    }

    public void updateExample(Example example) {
        jdbcTemplate.update(SQL_UPDATE_Example, example.getName(), example.getDescription(), example.getId());
    }

    public void saveExample(Example example) {
        jdbcTemplate.update(SQL_INSERT_EXAMPLE, example.getName(), example.getDescription(), example.getCreatedOn(), example.getUpdatedOn());
    }
}
