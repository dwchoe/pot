package start.service

import static java.lang.System.out;
import org.springframework.stereotype.Component

/**
 * Created by z0019mz on 6/3/17.
 */

@Component
class OutputService {

    def write() {
        out.println("Output.write()")
    }
}
