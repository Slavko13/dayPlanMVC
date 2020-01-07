package ru.dayplan.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {



    private String createFileNameForLogsFile() {
        String fileName = "lol";



        return fileName;
    }

//    private File fileCreating() {
//        {
//            try {
//
//                String uploadPath = "D://myProjects//Logs" +
//
//
//                        File file = new File(uploadPath);.
//
//                if (file.createNewFile())
//                    System.out.println("File created");
//                else
//                    System.out.println("File already exists");
//            }
//            catch (Exception e) {
//                System.err.println(e);
//            }
//        }
//
//        return file;
//    }



    @After(value = "execution(* ru.dayplan.service.TasksService.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After method:" + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* ru.dayplan.service.TasksService.*(..))", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        System.out.println(result.toString());
    }
}
