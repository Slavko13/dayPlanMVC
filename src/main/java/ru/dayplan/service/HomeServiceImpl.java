package ru.dayplan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dayplan.entity.Client;
import ru.dayplan.entity.Home;
import ru.dayplan.repository.HomeRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private ClientsService clientsService;

    @Override
    public void addHomeWithUser(Home home, String login) {

        Set<Client> clients = new HashSet<>();
        clients.add(clientsService.findClientByLogin(login));
        home.setClients(clients);
        homeRepository.save(home);


    }
}
