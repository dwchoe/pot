package poc.service

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

/**
 * Created by z0019mz on 5/14/16.
 */

@Component
class StockService {

    def getPrice(String stockSymbol) {
        return '50'
    }
}
