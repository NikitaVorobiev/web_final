package com.example.testTask.controllers.models;

/**
 * Данные конвертации
 */
public class ConverterDto {
    /**
     * Идентификатор валюты, из которой конвертируют
     */
    private int curr1;
    /**
     * Идентификатор валюты, в которую конвертируют
     */
    private int curr2;
    /**
     * Сумма, которую конвертируют
     */
    private String curr1value;
    /**
     * Результат конвертации
     */
    private String curr2value;

    public ConverterDto(){

    }

    public ConverterDto(int curr1, int curr2, String curr1value, String curr2value){
        this.curr1=curr1;
        this.curr2=curr2;
        this.curr1value=curr1value;
        this.curr2value=curr2value;
    }

    public int getCurr1() {
        return curr1;
    }

    public void setCurr1(int curr1) {
        this.curr1 = curr1;
    }

    public int getCurr2() {
        return curr2;
    }

    public void setCurr2(int curr2) {
        this.curr2 = curr2;
    }

    public String getCurr1value() {
        return curr1value;
    }

    public void setCurr1value(String curr1value) {
        this.curr1value = curr1value;
    }

    public String getCurr2value() {
        return curr2value;
    }

    public void setCurr2value(String curr2value) {
        this.curr2value = curr2value;
    }
}
