package ru.dayplan.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dayplan.entity.Client;
import ru.dayplan.entity.Home;

import java.util.List;
import java.util.Set;


@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
        Client findByLogin(String login);
        Client findByEmail(String email);

//        @Query("update Client Set fileName=:fileName WHERE login=:login")
//        void updateClient(@Param("login") String login, @Param("fileName") String fileName);
}
