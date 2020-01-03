package ru.dayplan.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.dayplan.entity.Home;
import ru.dayplan.entity.Tasks;

import java.util.List;
import java.util.Set;

public interface TasksRepository extends CrudRepository<Tasks, Integer> {


    List<Tasks> findAllByClientLoginOrderByTimeAsc(String login);

}
