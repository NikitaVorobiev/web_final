package com.example.testTask.controllers.userdata;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * Класс для хранения данных пользователя по сессиям
 */
@Service("userService")
public
class UserService {
    public static Map<String, Integer> usersCache = new HashMap<>();

    public void add(String sessionId, int userId){
        usersCache.put(sessionId, userId);
    }

    public void get(String id){
        usersCache.get(id);
    }
}
