package pot_java.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pot_java.dao.repository.StockDao;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        ApplicationContext context
                = new AnnotationConfigApplicationContext(App.class);

        StockDao stockDao = context.getBean(StockDao.class);
        stockDao.getStock();
    }
}
