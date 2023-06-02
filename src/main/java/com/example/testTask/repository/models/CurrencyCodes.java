package com.example.testTask.repository.models;

/**
 * Модель кодов валют из БД
 *
 * @param id идентификатор валюты
 * @param name название валюты
 */
public record CurrencyCodes(
        int id,
        String name
) {
}
