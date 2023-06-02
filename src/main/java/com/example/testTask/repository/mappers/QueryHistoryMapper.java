package com.example.testTask.repository.mappers;

import com.example.testTask.repository.models.QueryHistory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Маппер истории запросов к БД
 */
@Component
public class QueryHistoryMapper implements RowMapper<QueryHistory> {
    @Override
    public QueryHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new QueryHistory(
                rs.getString("curr1"),
                rs.getString("curr2"),
                rs.getString("value1"),
                rs.getString("value2"),
                rs.getString("date")
        );
    }
}
