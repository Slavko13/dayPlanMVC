package ru.dayplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dayplan.entity.Client;
import ru.dayplan.entity.Home;
import ru.dayplan.repository.ClientRepository;
import ru.dayplan.repository.HomeRepository;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service("ClientsService")
public class ClientServiceImpl implements ClientsService {


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);
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
        fileName = fileName + temp.toString() + ".jpg";
        return fileName;

    }

    public Set<Home> getHomesByClientsLogin(String login) {
        return homeRepository.findHomesByClientsLogin(login);
    }

    public Client findClientByLogin(String login) {
        return clientRepository.findByLogin(login);
    }


}
