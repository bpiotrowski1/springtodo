package pl.bpiotrowski.springtodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bpiotrowski.springtodo.dto.UserDto;

@Controller
public class UserController {

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDto userForm) {
        return "redirect:/login";
    }

}
