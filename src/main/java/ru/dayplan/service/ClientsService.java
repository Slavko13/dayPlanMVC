package ru.dayplan.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.dayplan.entity.Client;
import ru.dayplan.entity.Home;
import ru.dayplan.entity.Tasks;

import java.util.List;
import java.util.Set;

public interface ClientsService {

     void addClient(Client client);
     Client findClientByLogin(String login);
     Set<Home> getHomesByClientsLogin(String login);
     String generateOriginalFIleName(String login);
     Client updateClient(Client client);
     Client updateClientLoginTime(Client client);
     Client findClientByEmail(String email);
     Client findClientById(Integer id);
     List<Tasks> findTasksByClientsLogin(String login);
}
