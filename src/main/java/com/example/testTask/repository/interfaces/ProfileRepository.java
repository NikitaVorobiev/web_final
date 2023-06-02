package com.example.testTask.repository.interfaces;

/**
 * Интерфейс взаимодействия с базой пользователей
 */
public interface ProfileRepository {
    /**
     * Получение пользователя
     *
     * @param login логин
     * @param password пароль
     * @return -1 если пользователь не найден, id если найден
     */
    int getUser(String login, String password);

    /**
     * Получение пользователя
     *
     * @param login логин
     * @param password пароль
     */
    void addUser(String login, String password);
}
