package net.mateakademy.controllers;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import net.mateakademy.dto.User;
import net.mateakademy.entities.RoleEntity;
import net.mateakademy.service.RoleServiceImpl;
import net.mateakademy.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String helloUser() {
        return "index";
    }

    @GetMapping("/registration-form")
    public ModelAndView registerForm() {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("registration_form");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @PostMapping("/registration")
    public RedirectView userRegistration(@ModelAttribute("user") User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleService.getRoleById(2L));
        user.setRoles(roles);
        userService.createUser(user);

        return new RedirectView("/admin/users");
    }

    @GetMapping("/admin/users")
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView("users_list_Admin");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }

    @GetMapping("/admin/edit-user/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_user_Admin");
        User user = userService.getUserById(id);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @DeleteMapping("/admin/delete-user/{id}")
    public RedirectView deleteProduct(@PathVariable(name = "id") Long id) {
        userService.deleteUserById(id);
        return new RedirectView("/admin/users");
    }

    @GetMapping("/user/users")
    public ModelAndView allUsersForUser() {
        ModelAndView modelAndView = new ModelAndView("user_list_User");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }
}
