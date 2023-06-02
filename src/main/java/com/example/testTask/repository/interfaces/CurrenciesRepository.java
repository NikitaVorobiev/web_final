package com.example.testTask.repository.interfaces;

import com.example.testTask.currencyservice.dto.CurrenciesDto;
import com.example.testTask.repository.models.Currencies;
import com.example.testTask.repository.models.CurrencyCodes;
import com.example.testTask.repository.models.QueryHistory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Интерфейс взаимодйствия с базой завлют
 */
public interface CurrenciesRepository {

    /**
     * Получение значений конвертаций валют по дате
     *
     * @param date текущая дата
     * @return массив валют
     */
    Optional<List<Currencies>> getCurrenciesByDate(LocalDate date);

    /**
     * Сохранение данных валют
     *
     * @param currencies валюты
     */
    void insertCurrencies(CurrenciesDto currencies);

    /**
     * Получение кодов валют
     *
     * @return коды валют
     */
    List<CurrencyCodes> getCurrencyCodes();

    /**
     * Сохранение кодов валют
     *
     * @param code код
     * @param name название
     */
    void insertCurrencyCodes(String code, String name);

    /**
     * Получение истории запросов по пользователю
     *
     * @param userId идентификатор пользователя
     * @return история запросов
     */
    List<QueryHistory> getHistoryByUser(int userId);

    /**
     * Сохранение истории по пользователю
     *
     * @param curr1 название валюты, из которой конвертировали
     * @param curr2 название валюты, в которую конвертировали
     * @param value1 сумма, которую конвертировали
     * @param value2 результат конвертации
     * @param date дата проведения операции
     * @param userId идентификатор пользователя, проводившего операцию
     */
    void insertHistoryByUser(int curr1, int curr2, String value1, String value2, String date, int userId);
}
