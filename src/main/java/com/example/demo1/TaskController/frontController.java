package com.example.demo1.TaskController;

import com.example.demo1.entities.Task1;
import com.example.demo1.entities.User;
import com.example.demo1.services.TaskServices;
import com.example.demo1.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class frontController {
    TaskServices services;
    UserService userService;

    public frontController(TaskServices services, UserService userService) {
        this.services = services;
        this.userService = userService;
    }

    @GetMapping("/pruebath")
    public String Bienvenidos(@RequestParam(name = "name", required = false,defaultValue = "¿Como estas?")String nombre, Model model){
        model.addAttribute("nombre","Pepito");
        return "index";

    }
    @GetMapping("/")
    public String showindex(Model model, @AuthenticationPrincipal OidcUser principal){//Servicio para consultar la BD desde front(Thymeleaf)

        if(principal != null){
            User user = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user",user);
            }

        return "indexlp";
    }


    @GetMapping("/readtasks")
    public String showTaskList(){//Servicio para consultar la BD desde front(Thymeleaf)
        return "indexgt";  }

    @GetMapping("/tasks")
    public String showTaskList(Model model) {
        List<Task1> taskAll = this.services.getTaskList();
        model.addAttribute("taskList", taskAll);
        return "indexgt";
    }
    @GetMapping("/tasks/nuevotask")//Renderizar el formulario desde creatask.html
    public String creartareas(Model model) {
        model.addAttribute("taskList", new Task1());//Crea tarea vacia para luego diligenciarla en el formualrio
        return "createtask";
    }

}
