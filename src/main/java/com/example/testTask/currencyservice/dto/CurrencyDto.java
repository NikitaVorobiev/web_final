package com.example.testTask.currencyservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Модель для парсинга курса валют по одной валюте
 */
@Entity
@XmlRootElement(name = "Valute")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlElement(name = "NumCode")
    private String numCode;

    @XmlElement(name = "CharCode")
    private String charCode;

    @XmlElement(name = "Nominal")
    private int nominal;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Value")
    @JsonIgnore
    @Transient
    private String input_value;

    private double value;

    public String getTextValue(){
        return input_value;
    }

    public double getDoubleValue(){
        return value;
    }

    public String getCharCode(){
        return charCode;
    }

    public String getName(){
        return name;
    }

    public void setDoubleValue(double value){
        this.value = value / (double) nominal;
    }

    @Override
    public String toString() {
        return "\n" + name + " (" +
                "numCode = " + numCode + ", " +
                "charCode = " + charCode + ", " +
                "nominal = " + nominal + ", " +
                "value = " + value + ")";
    }
}
