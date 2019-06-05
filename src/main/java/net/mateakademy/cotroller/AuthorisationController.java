package net.mateakademy.cotroller;


@org.springframework.stereotype.Controller
@org.springframework.web.bind.annotation.RequestMapping("/log")
public class AuthorisationController {
   @org.springframework.web.bind.annotation.GetMapping
    public org.springframework.web.servlet.ModelAndView loginPage(){
        org.springframework.web.servlet.ModelAndView modelAndView = new org.springframework.web.servlet.ModelAndView();
        modelAndView.setViewName("log");
        return modelAndView;
    }
}
