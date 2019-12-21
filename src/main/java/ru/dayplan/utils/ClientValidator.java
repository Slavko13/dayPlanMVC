package ru.dayplan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.dayplan.entity.Client;
import ru.dayplan.service.ClientsService;


@Component
public class ClientValidator implements Validator {

    @Autowired
    private ClientsService clientsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Client client = (Client) o;
        if (clientsService.findClientByLogin(client.getLogin()) != null) {
            errors.rejectValue("login", "", "This login already exist");
        }
        else {
            if (clientsService.findClientByEmail(client.getEmail()) != null) {
                errors.rejectValue("email", "", "This email already registered");
            }
        }
    }
}
