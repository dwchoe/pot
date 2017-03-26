import service.MyService;

/**
 * Created by z0019mz on 5/15/16.
 */
public class Starter {
    public static void main(String [] args) {
        System.out.println("starting up");

        MyService myService = new MyService();
        myService.getPrice();
    }
}
