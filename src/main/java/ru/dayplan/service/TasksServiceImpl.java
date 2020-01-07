package ru.dayplan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import ru.dayplan.entity.Tasks;
import ru.dayplan.repository.TasksRepository;

import java.util.List;
import java.util.Set;

@Service
public class TasksServiceImpl implements TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private ClientsService clientsService;

    @Override
    public boolean addTask(Tasks task) {
        tasksRepository.save(task);
        return true;
    }


    @Override
    public boolean deleteTask(Integer id) {
        Tasks task = findTaskById(id);
        if (task != null) {
            tasksRepository.delete(task);
            return true;
        }
        return false;
    }

    @Override
    public Tasks findTaskById(Integer id) {
        return tasksRepository.findById(id).get();
    }
}
