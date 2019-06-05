package net.mateakademy.cotroller;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @org.springframework.web.bind.annotation.GetMapping("/")
    public String index() {
        return "main";
    }
}
