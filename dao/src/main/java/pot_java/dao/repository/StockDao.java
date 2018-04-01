package pot_java.dao.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import pot_java.dao.domain.Stock;

@Repository
@Slf4j
public class StockDao {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
