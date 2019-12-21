package ru.dayplan.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dayplan.entity.Home;

import java.util.Optional;
import java.util.Set;


@Repository
public interface HomeRepository extends CrudRepository<Home, Integer> {
    Home findByAddress(String address);

    @Query("SELECT u.homes FROM Client u WHERE u.login = :login")
    Set<Home> findHomesByClientsLogin(@Param("login") String login);


}
