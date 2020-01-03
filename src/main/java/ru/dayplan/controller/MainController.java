package ru.dayplan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.dayplan.entity.Client;
import ru.dayplan.entity.Home;
import ru.dayplan.service.ClientServiceImpl;
import ru.dayplan.service.ClientsService;
import ru.dayplan.service.HomeService;

import javax.persistence.Access;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

@Controller
public class MainController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private ClientsService clientService;

    @Autowired
    private HomeService homeService;

    @GetMapping({"/home", "/"})
    public String viewHome(Model model, @AuthenticationPrincipal Client activeClient) {
        if (activeClient != null) {
            model.addAttribute("id", activeClient.getId());
            model.addAttribute("name", activeClient.getFirst_name());
        }
        else {
            model.addAttribute("id", 0);
        }

        return "homePageView";
    }

    @GetMapping("/id{id}")
    public ModelAndView viewClients(@PathVariable Integer id) {
        ModelAndView clientsView = new ModelAndView("clientsView");
        Client client = clientService.findClientById(id);
        clientsView.addObject("client", client);
        return clientsView;
    }

    @PostMapping("/upload/file")
    public String uploadFile(@RequestParam("file") MultipartFile file, @AuthenticationPrincipal Client activeClient) throws IOException {
        Client client = clientService.findClientByLogin(activeClient.getLogin());

            String fileName = clientService.generateOriginalFIleName(activeClient.getLogin());
            Path fileNameAndPath = Paths.get(uploadPath, fileName);
            Files.write(fileNameAndPath, file.getBytes());
            client.setFileName(fileName);
        clientService.updateClient(client);

        return "redirect:/clients";
    }

    @GetMapping("/tags")
    public String viewTags(Model model, @AuthenticationPrincipal Client activeClient) {
        if (activeClient != null) {
            model.addAttribute("id", activeClient.getId());
            model.addAttribute("name", activeClient.getFirst_name());
        }
        Client client = clientService.findClientByLogin(activeClient.getLogin());
        model.addAttribute("HomesTags", clientService.getHomesByClientsLogin(client.getLogin()));
        return "tagsView";
    }

    @PostMapping("/tags")
    public String addHome(@ModelAttribute Home home, @AuthenticationPrincipal Client activeClient) {
        homeService.addHomeWithUser(home, activeClient.getLogin());

        return "redirect:/tags";
    }
}
