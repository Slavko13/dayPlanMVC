package ru.dayplan.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.dayplan.entity.Client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {


    private String createFileNameForLogsFile() {
        String fileName = "";


        return fileName;
    }

    private void fileCreatingAndLogAdding(String logText, String clientName) {
        String fileName = "userLogs";
        String uploadPath = "D://myProjects//Logs//" + fileName + clientName + ".txt";
        try {
            File file = new File(uploadPath);
            if (file.createNewFile()) {
                System.out.println("File created");
            }
            else
                System.out.println("File already exists");
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            FileWriter writer = new FileWriter(uploadPath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(logText);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }

}



    @After(value = "execution(* ru.dayplan.service.TasksService.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After method:" + joinPoint.getSignature());
    }

    @AfterReturning(value = "execution(* ru.dayplan.service.ClientsService.updateClientLoginTime(..))", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        Client client = (Client) result;
        System.out.println(joinPoint.getSignature().getName());
        fileCreatingAndLogAdding(client.getLogInTime(), client.getLogin());
    }


}
