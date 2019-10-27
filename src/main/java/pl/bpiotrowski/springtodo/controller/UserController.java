package pl.bpiotrowski.springtodo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bpiotrowski.springtodo.dto.UserDto;
import pl.bpiotrowski.springtodo.service.UserService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute UserDto userForm) {
        userService.create(userForm);
        return "redirect:/login";
    }

}
