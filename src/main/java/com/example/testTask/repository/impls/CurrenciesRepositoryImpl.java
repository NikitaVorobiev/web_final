package com.example.testTask.repository.impls;

import com.example.testTask.currencyservice.dto.CurrenciesDto;
import com.example.testTask.currencyservice.dto.CurrencyDto;
import com.example.testTask.repository.interfaces.CurrenciesRepository;
import com.example.testTask.repository.mappers.CurrenciesMapper;
import com.example.testTask.repository.mappers.CurrencyCodesMapper;
import com.example.testTask.repository.mappers.QueryHistoryMapper;
import com.example.testTask.repository.models.Currencies;
import com.example.testTask.repository.models.CurrencyCodes;
import com.example.testTask.repository.models.QueryHistory;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CurrenciesRepositoryImpl implements CurrenciesRepository {
    private final CurrenciesMapper currenciesMapper;
    private final CurrencyCodesMapper currencyCodesMapper;
    private final QueryHistoryMapper queryHistoryMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private static final String SQL_GET_CURRENCIES_BY_DATE =
            "select date, curr0, curr1, curr2, curr3, curr4, curr5, curr6, curr7, curr8, curr9, curr10, curr11, curr12, curr13, curr14, curr15, curr16, curr17, curr18, curr19, curr20, curr21, curr22, curr23, curr24, curr25, curr26, curr27, curr28, curr29, curr30, curr31, curr32, curr33, curr34" +
                    " from currency_history where date = :date";

    private static final String SQL_INSERT_CURRENCIES_BY_DATE =
            "insert into currency_history (date, curr0, curr1, curr2, curr3, curr4, curr5, curr6, curr7, curr8, curr9, curr10, curr11, curr12, curr13, curr14, curr15, curr16, curr17, curr18, curr19, curr20, curr21, curr22, curr23, curr24, curr25, curr26, curr27, curr28, curr29, curr30, curr31, curr32, curr33, curr34)" +
                    "values (:date, :curr0, :curr1, :curr2, :curr3, :curr4, :curr5, :curr6, :curr7, :curr8, :curr9, :curr10, :curr11, :curr12, :curr13, :curr14, :curr15, :curr16, :curr17, :curr18, :curr19, :curr20, :curr21, :curr22, :curr23, :curr24, :curr25, :curr26, :curr27, :curr28, :curr29, :curr30, :curr31, :curr32, :curr33, 1)";

    private static final String SQL_GET_CURRENCY_CODES =
            "select * from currency_codes";

    private static final String SQL_INSERT_CURRENCY_CODES =
            "insert into currency_codes (char_code, name) values (:code, :name)";

    private static final String SQL_GET_HISTORY =
            "select curr1, curr2, value1, value2, date from query_history where user_id = :id";

    private static final String SQL_INSERT_HISTORY =
            "insert into query_history (curr1, curr2, value1, value2, date, user_id) values (:curr1, :curr2, :value1, :value2, :date, :id)";

    public CurrenciesRepositoryImpl(
            CurrenciesMapper currenciesMapper,
            CurrencyCodesMapper currencyCodesMapper,
            NamedParameterJdbcTemplate jdbcTemplate,
            QueryHistoryMapper queryHistoryMapper
    ) {
        this.currenciesMapper = currenciesMapper;
        this.currencyCodesMapper = currencyCodesMapper;
        this.jdbcTemplate = jdbcTemplate;
        this.queryHistoryMapper = queryHistoryMapper;
    }

    @Override
    public Optional<List<Currencies>> getCurrenciesByDate(LocalDate date) {
        var params = new MapSqlParameterSource();
        params.addValue("date", date.toString());
        return jdbcTemplate.query(
                        SQL_GET_CURRENCIES_BY_DATE,
                        params,
                        currenciesMapper
                ).stream()
                .findFirst();
    }

    @Override
    public void insertCurrencies(CurrenciesDto currencies) {
        var params = new MapSqlParameterSource();
        params.addValue("date", currencies.getDate());
        int i = 0;
        for (CurrencyDto curr: currencies.getCurrencies()){
            params.addValue(String.format("curr%s", i++), curr.getDoubleValue());
        }
        jdbcTemplate.update(SQL_INSERT_CURRENCIES_BY_DATE, params);
    }

    @Override
    public List<CurrencyCodes> getCurrencyCodes() {
        var params = new MapSqlParameterSource();

        ArrayList<CurrencyCodes> result = new ArrayList<>(jdbcTemplate.query(
                SQL_GET_CURRENCY_CODES,
                params,
                currencyCodesMapper
        ));
        if (result.isEmpty())
            return new ArrayList<>();
        return result;
    }

    @Override
    public void insertCurrencyCodes(String code, String name) {
        var params = new MapSqlParameterSource();
        params.addValue("code", code);
        params.addValue("name", name);
        jdbcTemplate.update(SQL_INSERT_CURRENCY_CODES, params);
    }

    @Override
    public List<QueryHistory> getHistoryByUser(int userId) {
        var params = new MapSqlParameterSource();
        params.addValue("id", userId);

        ArrayList<QueryHistory> result = new ArrayList<>(jdbcTemplate.query(
                SQL_GET_HISTORY,
                params,
                queryHistoryMapper
        ));

        if(result.isEmpty())
            return new ArrayList<>();
        return result;
    }

    @Override
    public void insertHistoryByUser(int curr1, int curr2, String value1, String value2, String date, int userId) {
        var params = new MapSqlParameterSource();
        List<CurrencyCodes> codes = getCurrencyCodes();

        params.addValue("curr1", codes.get(curr1).name());
        params.addValue("curr2", codes.get(curr2).name());
        params.addValue("value1", value1);
        params.addValue("value2", value2);
        params.addValue("date", date);
        params.addValue("id", userId);
        jdbcTemplate.update(SQL_INSERT_HISTORY, params);
    }
}
