package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.app.todoapp.services.TaskService;

import java.util.List;

@Controller
//@RequestMapping("/michiel")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public String getTasks(Model model){
      List<Task> tasks = taskService.getAllTasks();
       model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping()
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }

}
