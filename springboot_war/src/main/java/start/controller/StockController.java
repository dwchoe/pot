package start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import poc.service.StockService;
import start.service.PriceService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by z0019mz on 1/2/16.
 */



@RestController
public class StockController {

    @Autowired
    PriceService priceService;

    @Autowired
    StockService stockService;

    @RequestMapping("/stock")
    @ResponseBody
    String echo() {
        return "echo - " + priceService.getPrice() + " - " + stockService.getPrice("BAC");
    }

//    @AroundMethod
//    public String multiply(HttpServletRequest request, @RequestParam @ChangeParam String number) {
//        log.info("Processing multiply method with a number parameter = {}", number);
//        return number + " * ";
//    }

}
