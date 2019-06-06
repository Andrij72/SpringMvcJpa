package net.mateakademy.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
public class AuthorisationController {
   @GetMapping
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new org.springframework.web.servlet.ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
