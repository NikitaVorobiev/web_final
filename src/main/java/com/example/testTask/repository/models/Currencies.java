package com.example.testTask.repository.models;

/**
 * Модель значения конвертации из БД
 *
 * @param value множитель конвертации в рубли
 */
public record Currencies(
        Double value
) {
}
