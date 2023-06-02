package com.example.testTask.currencyservice.impls;

import com.example.testTask.controllers.models.HistoryDto;
import com.example.testTask.currencyservice.dto.CurrenciesDto;
import com.example.testTask.currencyservice.dto.CurrencyDto;
import com.example.testTask.currencyservice.interfaces.CurrencyService;
import com.example.testTask.repository.interfaces.CurrenciesRepository;
import com.example.testTask.repository.models.Currencies;
import com.example.testTask.repository.models.QueryHistory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CurrencyServiceImpl implements CurrencyService {

    private final RestTemplate restTemplate;
    private final CurrenciesRepository currenciesRepository;
    String url = "http://www.cbr.ru/scripts/XML_daily.asp";

    private Optional<List<Currencies>> currencies;

    public CurrencyServiceImpl(RestTemplateBuilder restTemplateBuilder, CurrenciesRepository currenciesRepository) {
        this.restTemplate = restTemplateBuilder.build();
        this.currenciesRepository = currenciesRepository;
    }

    /**
     * Получение значений валют из апи
     *
     * @return данные по валютам
     */
    private CurrenciesDto getCurrencies(){
        CurrenciesDto currencies = restTemplate.getForObject(url, CurrenciesDto.class);

        if (currencies != null){
            currencies.getCurrencies()
                    .forEach(t -> {
                        t.setDoubleValue(
                                Double.parseDouble(t.getTextValue().replace(",", ".")));
                    });
            System.out.println(currencies);
            return currencies;
        }

        return null;
    }

    @Override
    public void update(LocalDate date) {
        currencies = currenciesRepository.getCurrenciesByDate(date);

        if (currencies.isEmpty()) {
            currenciesRepository.insertCurrencies(getCurrencies());
            currencies = currenciesRepository.getCurrenciesByDate(date);
        }
    }

    @Override
    public void load() {
        CurrenciesDto currencies = getCurrencies();

        currenciesRepository.insertCurrencies(currencies);
        assert currencies != null;
        for (CurrencyDto curr : currencies.getCurrencies()){
            currenciesRepository.insertCurrencyCodes(curr.getCharCode(), curr.getName());
        }
    }

    @Override
    public String calculate(int curr1, int curr2, Double curr1value, int userId) {
        update(LocalDate.now());
        List<Currencies> locCurs = currencies.get();

        String result = String.valueOf((curr1value * locCurs.get(curr1).value()) / (locCurs.get(curr2).value()));
        currenciesRepository.insertHistoryByUser(
                curr1, curr2, curr1value.toString(), result, LocalDate.now().toString(), userId
        );

        return result;
    }

    @Override
    public ArrayList<HistoryDto> getHistoryByUser(int userId) {
        List<QueryHistory> history = currenciesRepository.getHistoryByUser(userId);
        ArrayList<HistoryDto> result = new ArrayList<>();

        for (QueryHistory q: history){
            result.add(new HistoryDto(q.curr1(), q.curr2(), q.value1(), q.value2(), q.date()));
        }

        return result;
    }
}
