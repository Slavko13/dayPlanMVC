package ru.dayplan.service;

import ru.dayplan.entity.Home;

public interface HomeService {
   public void addHomeWithUser(Home home, String login);
}
