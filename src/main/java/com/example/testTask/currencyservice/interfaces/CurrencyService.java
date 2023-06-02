package com.example.testTask.currencyservice.interfaces;

import com.example.testTask.controllers.models.HistoryDto;
import com.example.testTask.repository.models.QueryHistory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Интерфейс класса для получения курса валют
 */
public interface CurrencyService {

    /**
     * Обновить курс валют
     *
     * @param date текущая дата
     */
    void update(LocalDate date);

    /**
     * Загрузка всех данных
     */
    void load();

    /**
     * Рассчет конвертации
     *
     * @param curr1 идентификатор валюты, из которой конвертируют
     * @param curr2 идентификатор валюты, в которую конвертируют
     * @param curr1value сумма, которую нужно сконвертировать
     * @param userId идентификатор пользователя, совершившего операцию
     * @return строка, содержащая результат конвертации
     */
    String calculate(int curr1, int curr2, Double curr1value, int userId);

    /**
     * Получение истории запросов по пользователю
     *
     * @param userId идентификатор пользователя
     * @return массив запросов на конвертацию от пользователя
     */
    ArrayList<HistoryDto> getHistoryByUser(int userId);
}
