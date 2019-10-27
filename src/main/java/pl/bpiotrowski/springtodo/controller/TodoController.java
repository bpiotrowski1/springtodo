package pl.bpiotrowski.springtodo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bpiotrowski.springtodo.entity.Todo;
import pl.bpiotrowski.springtodo.service.TodoService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public String start(Model model) {
        model.addAttribute("todoList", todoService.findAll());
        return "todo";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        todoService.delete(id);
        return "redirect:/todo";
    }

    @PostMapping
    public String addTask(@ModelAttribute("todo") Todo todo, BindingResult errors) {
        if(errors.hasErrors()) {
            return "todo";
        }

        todoService.create(todo);
        return "redirect:todo";
    }

    @ModelAttribute
    public Todo todo() {
        return new Todo();
    }
}
