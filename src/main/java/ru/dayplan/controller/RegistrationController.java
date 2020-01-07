package ru.dayplan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.dayplan.entity.Client;
import ru.dayplan.service.ClientsService;
import ru.dayplan.utils.ClientValidator;

import javax.validation.Valid;
import java.time.LocalTime;

@Controller
public class RegistrationController {

    @Autowired
    private ClientValidator clientValidator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("ClientsService")
    private ClientsService clientService;


    @PostMapping("/registration")
    public String addClient(@ModelAttribute @Valid Client client,
                            BindingResult result, Model model) {
        clientValidator.validate(client, result);
        if (result.hasErrors()) {
            model.addAttribute("errorCounter", result.getErrorCount());
            model.addAttribute("error", result.getFieldError().getDefaultMessage());
            return "registrationView";
        }
        clientService.addClient(client);
        return "redirect:/login";
    }



    @GetMapping("/registration")
    public String viewClients(Model model) {
        model.addAttribute("isAuth", false);
        model.addAttribute("errorCounter", 0);
    return "registrationView";
    }


    @GetMapping("/recoverPass")
    public String recoverPassword(@RequestParam("email") String email,
                                  @RequestParam("password") String password) {

        Client client = clientService.findClientByEmail(email);
        client.setPassword(passwordEncoder.encode(password));
        clientService.updateClient(client);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginError(@RequestParam(name = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        model.addAttribute("isAuth", false);
        return "loginView";
    }





}
