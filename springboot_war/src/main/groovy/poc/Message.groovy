import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
public class MessageController {
    @RequestMapping("/msg")
    @ResponseBody
    String echo() {
        System.out.println("HelloController - msg");
        return "echo";
    }
}
