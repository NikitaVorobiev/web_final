package com.example.testTask.controllers.models;

/**
 * Данные истории операций
 */
public class HistoryDto {
    /**
     * Идентификатор валюты, из которой конвертируют
     */
    String curr1;
    /**
     * Идентификатор валюты, в которую конвертируют
     */
    String curr2;
    /**
     * Сумма, которую конвертируют
     */
    String value1;
    /**
     * Результат конвертации
     */
    String value2;
    /**
     * Дата проведения операции
     */
    String date;

    public HistoryDto(){

    }

    public HistoryDto(
            String curr1,
            String curr2,
            String value1,
            String value2,
            String date
    ){
        this.curr1 = curr1;
        this.curr2 = curr2;
        this.value1 = value1;
        this.value2 = value2;
        this.date = date;
    }

    public String getCurr1() {
        return curr1;
    }

    public void setCurr1(String curr1) {
        this.curr1 = curr1;
    }

    public String getCurr2() {
        return curr2;
    }

    public void setCurr2(String curr2) {
        this.curr2 = curr2;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
