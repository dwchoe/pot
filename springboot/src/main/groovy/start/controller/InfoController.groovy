package start.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import start.service.OutputService

/**
 * Created by z0019mz on 6/3/17.
 */

@RestController
class InfoController {

    @Autowired
    OutputService outputService

    @RequestMapping("/myinfo")
    @ResponseBody
    String home() {
        outputService.write()

        return "hello world"
    }
}
