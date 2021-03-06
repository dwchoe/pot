package start.controller;

import static start.config.LogConstants.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import start.aspect.AppRequest;
import start.aspect.AppResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by z0019mz on 5/14/16.
 */

@Controller
public class HomePageController {

    @RequestMapping("/")
    @AppRequest
    @AppResponse
    public ResponseEntity<?> homepage(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        System.out.println("/home");
        // look up "homepage" template in src/main/resources/templates/homepage.html
        return new ResponseEntity("hello", HttpStatus.OK);
    }
}