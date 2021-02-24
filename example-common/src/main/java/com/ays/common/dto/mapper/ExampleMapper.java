package com.ays.common.dto.mapper;

import com.ays.entities.Example;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExampleMapper implements RowMapper<Example> {

	public Example mapRow(ResultSet resultSet, int i) throws SQLException {
		Example example = new Example();
		example.setId(resultSet.getLong("id"));
		example.setName(resultSet.getString("name"));
		example.setDescription(resultSet.getString("description"));
		return example;
	}
}
