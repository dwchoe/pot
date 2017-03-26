package com.sandbox.resource;

import com.sandbox.service.BOMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static java.lang.System.out;

// creates servlet and loaded into the Servlet Dispatcher from /WEB-INF/rest-servlet.xml
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
//    private BOMService bomService;

    // URI: /message
    @RequestMapping(method = RequestMethod.GET)
    public String message() {
//        bomService.action();
        return "app is up";
    }

    // URI: /message/{name}
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String ping(@PathVariable String name) {
        out.println(name);
        return name;
    }

}
