package az.maqa.project.springsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public ModelAndView getLoginView(){
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    @GetMapping("index")
    public ModelAndView getIndexPage(){
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping(value = "login/google")
    public Principal user(Principal principal) {
        return principal;
    }

}
