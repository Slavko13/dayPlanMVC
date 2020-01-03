package ru.dayplan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.dayplan.entity.Client;
import ru.dayplan.entity.Tasks;
import ru.dayplan.service.ClientsService;
import ru.dayplan.service.TasksService;
import ru.dayplan.utils.TaskValidator;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
public class TaskController {

    @Autowired
    private TaskValidator taskValidator;

    @Autowired
    private TasksService tasksService;

    @Autowired
    private ClientsService clientsService;

    @GetMapping("/tasks")
    public String taskView(Model model, @AuthenticationPrincipal Client activeClient){
        List<Tasks> tasks = clientsService.findTasksByClientsLogin(activeClient.getLogin());
        model.addAttribute("id", activeClient.getId());
        model.addAttribute("name", activeClient.getFirst_name());
        model.addAttribute("tasksList", tasks );
        return "taskView";
    }

    @PostMapping("/tasks/addProcess")
    public ModelAndView taskAdd(ModelMap model,
                                @ModelAttribute Tasks task,
                                @AuthenticationPrincipal Client activeClient,
                                @RequestParam("hours") String hours,
                                @RequestParam("minutes") String minutes,
                                @RequestParam("holdingHours") Integer holdingHours,
                                @RequestParam("holdingMinutes") Integer holdingMinutes,
                                BindingResult result) {
        task.setClient(clientsService.findClientByLogin(activeClient.getLogin()));
        task.setTime(hours + ":" + minutes);
        task.setHoldingTime(holdingHours*60 + holdingMinutes);
        taskValidator.validate(task, result);
        if (result.hasErrors()) {

            model.addAttribute("errors", result.getFieldError().getDefaultMessage());
            return new ModelAndView("redirect:/tasks" , model);
        }
        tasksService.addTask(task);
        return  new ModelAndView ("redirect:/tasks");
    }

    @PostMapping("tasks/deleteProcess")
    public String taskDelete(@RequestParam("id") Integer id) {

        tasksService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/task/{id}")
    public String oneTaskView(@PathVariable Integer id,
            @AuthenticationPrincipal Client activeClient, Model model) {
        if (activeClient != null) {
            model.addAttribute("id", activeClient.getId());
            model.addAttribute("name", activeClient.getFirst_name());
        }

        Tasks task = tasksService.findTaskById(id);
        model.addAttribute("taskName", task.getTaskName());

        return "oneTaskView";
    }


}
