package com.example.testTask.currencyservice.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Модель для парсинга списка валют
 */
@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrenciesDto implements Serializable {

    @XmlElement(name = "Valute")
    private List<CurrencyDto> currencies;

    private final LocalDate date = LocalDate.now();

    public List<CurrencyDto> getCurrencies(){
        return currencies;
    }

    public LocalDate getDate(){
        return date;
    }
}
