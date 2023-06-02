package com.example.testTask.repository.models;

/**
 * Модель истории запросов из БД
 *
 * @param curr1 название валюты из которой конвертируют
 * @param curr2 название валюты, в которую конвертируют
 * @param value1 сумма, которую конвертируют
 * @param value2 результат конвертации
 * @param date дата проведения операции
 */
public record QueryHistory(
        String curr1,
        String curr2,
        String value1,
        String value2,
        String date
) {
}
