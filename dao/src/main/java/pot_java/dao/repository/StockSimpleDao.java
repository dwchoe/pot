package pot_java.dao.repository;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import pot_java.dao.domain.Stock;
import javax.sql.DataSource;

// Standalone DAO where the datasource and template are created within this class.  Normally,
// it not done this way, but handy for testing a DB connection without a Spring container.

@Repository
public class StockSimpleDao {
    private DataSource dataSource;
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StockSimpleDao() {
        dataSource = DataSourceBuilder
                .create()
                .username("FAKE_USERNAME")
                .password("FAKE_PASSWORD")
                .url("FAKE_URL")
                .driverClassName("org.postgresql.Driver")
                .build();

        jdbcTemplate = new JdbcTemplate(dataSource);

        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public Stock getStock() {
        Stock stock = null;
        try {
            SqlParameterSource params = new MapSqlParameterSource();
            ((MapSqlParameterSource) params).addValue("symbol","BAC");
            stock = namedParameterJdbcTemplate.queryForObject("select company_name from stock where symbol=:symbol", params,
                    (resultSet, rowNum) -> {
                        Stock stockVO = new Stock();
                        stockVO.setConfirmationNumber(resultSet.getString("company_name"));
                        return stockVO;

                    });
            System.out.println("stock:" + stock);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return stock;
    }
}
