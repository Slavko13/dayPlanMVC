package ru.dayplan.service;

import org.springframework.scheduling.config.Task;
import ru.dayplan.entity.Tasks;

public interface TasksService  {
    boolean addTask(Tasks tasks);
    boolean deleteTask(Integer id);
    Tasks findTaskById(Integer id);


}
