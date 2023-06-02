package com.example.testTask.repository.mappers;

import com.example.testTask.repository.models.Currencies;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Маппер валют
 */
@Component
public class CurrenciesMapper implements RowMapper<List<Currencies>> {

    @Override
    public List<Currencies> mapRow(ResultSet rs, int rowNum) throws SQLException {
        ArrayList<Currencies> result = new ArrayList<>();

        result.add(new Currencies(Double.parseDouble(rs.getString("curr0").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr1").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr2").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr3").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr4").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr5").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr6").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr7").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr8").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr9").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr10").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr11").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr12").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr13").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr14").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr15").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr16").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr17").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr18").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr19").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr20").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr21").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr22").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr23").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr24").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr25").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr26").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr27").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr28").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr29").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr30").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr31").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr32").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr33").replace(",", "."))));
        result.add(new Currencies(Double.parseDouble(rs.getString("curr34").replace(",", "."))));

        return result;
    }

}
