package ru.dayplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dayplan.entity.Client;
import ru.dayplan.entity.Home;
import ru.dayplan.entity.Tasks;
import ru.dayplan.repository.ClientRepository;
import ru.dayplan.repository.HomeRepository;
import ru.dayplan.repository.TasksRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("ClientsService")
public class ClientServiceImpl implements ClientsService {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Client updateClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public Client updateClientLoginTime(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public Client findClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public void addClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
    }

    @Override
    public Client findClientById(Integer id) {
        return clientRepository.findById(id).get();
    }

    public String generateOriginalFIleName(String clientLogin) {

        Date date = new Date();
        Long millis = date.getTime();
        String fileName = millis.toString();
        Integer temp = clientLogin.hashCode();
        fileName = fileName + temp.toString() + ".xlsx";
        return fileName;

    }

    @Override
    public Set<Home> getHomesByClientsLogin(String login) {
        return homeRepository.findHomesByClientsLogin(login);
    }

    @Override
    public Client findClientByLogin(String login) {
        return clientRepository.findByLogin(login);
    }

    @Override
    public List<Tasks> findTasksByClientsLogin(String login) {
        return tasksRepository.findAllByClientLoginOrderByTimeAsc(login);
    }

}
