package ru.dayplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.dayplan.repository.ClientRepository;
import ru.dayplan.repository.HomeRepository;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Application {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private HomeRepository homeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
