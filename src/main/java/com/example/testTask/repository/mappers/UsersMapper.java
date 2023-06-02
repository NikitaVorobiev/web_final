package com.example.testTask.repository.mappers;

import com.example.testTask.repository.models.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Маппер моделей польззователей
 */
@Component
public class UsersMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getInt("id")
        );
    }
}
