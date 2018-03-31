package pot_java.dao.service;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import pot_java.dao.domain.Stock;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Date;
import java.util.List;

@Repository
public class StockDao {
    private DataSource dataSource;
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    String SELECT_SQL = "SELECT * from table";

    public StockDao() {
        dataSource = DataSourceBuilder
                .create()
                .username("")
                .password("")
                .url("")
                .driverClassName("org.postgresql.Driver")
                .build();

        jdbcTemplate = new JdbcTemplate(dataSource);

        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public List getObject() {
        List result = null;
        try {
            SqlParameterSource params = createParam();
            result = namedParameterJdbcTemplate.queryForList(SELECT_SQL, params, Stock.class);
        }
        catch (Exception e) {

        }
        return result;
    }

    public  SqlParameterSource createParam() {
        String startWindow = "2018-02-08T16:30:55Z";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("FIELD", "VALUE");
        params.addValue("FIELD", new java.sql.Date(new Date().getTime()), Types.TIMESTAMP);
        return params;
    }
}
