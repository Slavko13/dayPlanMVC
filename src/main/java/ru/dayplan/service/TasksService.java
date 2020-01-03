package ru.dayplan.service;

import org.springframework.scheduling.config.Task;
import ru.dayplan.entity.Tasks;

public interface TasksService  {
    void addTask(Tasks tasks);
    void deleteTask(Integer id);
    Tasks findTaskById(Integer id);


}
