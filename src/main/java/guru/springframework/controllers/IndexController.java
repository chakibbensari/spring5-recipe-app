package guru.springframework.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class IndexController {

    @RequestMapping({"/", "/index", "/index.html"})
    public String index(Model model, HttpServletRequest httpServletRequest){

        log.debug("displaying the index page for : " + httpServletRequest.getRequestURI());
        return "index";
    }
}
