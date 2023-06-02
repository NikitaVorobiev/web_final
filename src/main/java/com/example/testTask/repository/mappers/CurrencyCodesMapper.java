package com.example.testTask.repository.mappers;

import com.example.testTask.repository.models.CurrencyCodes;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Маппер кодов валют
 */
@Component
public class CurrencyCodesMapper implements RowMapper<CurrencyCodes> {
    @Override
    public CurrencyCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CurrencyCodes(
                rs.getInt("id"),
                rs.getString("name")
        );
    }
}
