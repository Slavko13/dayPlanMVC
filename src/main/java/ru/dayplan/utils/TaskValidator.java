package ru.dayplan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.dayplan.entity.Tasks;
import ru.dayplan.repository.TasksRepository;

import java.util.List;
import java.util.Set;

@Component
public class TaskValidator implements Validator {

    @Autowired
    private TasksRepository tasksRepository;


    @Override
    public boolean supports(Class<?> aClass) {
        return Tasks.class.equals(aClass);
    }

    private Integer formatTimeToMinutes(String time) {
        String[] subStr = time.split(":");
        int minutes = Integer.parseInt(subStr[1]);
        int hours = Integer.parseInt(subStr[0]);
        return minutes + hours * 60;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Tasks newTask = (Tasks) o;
        List<Tasks> tasksList = tasksRepository.findAllByClientLoginOrderByTimeAsc(newTask.getClient().getLogin());

        if(tasksList.size() == 1) {
            if(formatTimeToMinutes(tasksList.get(0).getTime() ) + tasksList.get(0).getHoldingTime() <
                    formatTimeToMinutes(newTask.getTime()) - newTask.getRoadTime() ) {
                errors.rejectValue("time", "", "Вы тупо не успеете туда");
            }

            if (formatTimeToMinutes(newTask.getTime()) + newTask.getHoldingTime() >
                    formatTimeToMinutes(tasksList.get(0).getTime()) - tasksList.get(0).getRoadTime() ) {
                errors.rejectValue("time", "", "Вы тупо не успеете туда");
            }
        }

        else if (tasksList.size() != 0){ {

        for (int i=0; i< tasksList.size()-1; i++) {
            int timeFirstTask = formatTimeToMinutes(tasksList.get(i).getTime())+tasksList.get(i).getHoldingTime()+newTask.getRoadTime();
            int timeSecondTask = formatTimeToMinutes(tasksList.get(i+1).getTime())-tasksList.get(i+1).getRoadTime();
            int timeNewTask = formatTimeToMinutes(newTask.getTime())+newTask.getHoldingTime();

            if ((timeFirstTask < timeNewTask) & (timeSecondTask > timeNewTask) ) {
                break;
            }
            if (i == tasksList.size()-2) {
                errors.rejectValue("time", "", "Вы тупо не успеете туда");
            }
        }

        }
    }
    }

}
