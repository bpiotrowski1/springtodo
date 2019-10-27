package pl.bpiotrowski.springtodo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bpiotrowski.springtodo.dto.TodoDto;
import pl.bpiotrowski.springtodo.service.TodoService;

import javax.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public String taskList(Model model, Principal principal) {
        model.addAttribute("todoForm", new TodoDto());
        model.addAttribute("todoList", todoService.findAllByUserUsername(principal.getName()));
        return "todo";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        todoService.delete(id);
        return "redirect:/";
    }

    @PostMapping
    public String addTask(@Valid TodoDto todoForm, Principal principal) {
        todoService.create(todoForm, principal.getName());
        return "redirect:/";
    }

//    @PostMapping
//    public String addTask(@Valid @ModelAttribute("todo") Todo todo, BindingResult errors) {
//        if(errors.hasErrors()) {
//            return "todo";
//        }
//
//        todoService.create(todo);
//        return "redirect:/";
//    }
}
