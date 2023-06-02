package com.example.testTask.controllers;

import com.example.testTask.controllers.models.ConverterDto;
import com.example.testTask.controllers.models.HistoryDto;
import com.example.testTask.controllers.models.Person;
import com.example.testTask.controllers.userdata.UserService;
import com.example.testTask.currencyservice.interfaces.CurrencyService;
import com.example.testTask.repository.interfaces.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

/**
 * Контроллер приложения
 */
@Controller
public class MainController {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    CurrencyService currencyService;

    /**
     * Страница конвертации валют
     */
    @GetMapping("/convert")
    public String convert(Model model){
        int userId = UserService.usersCache.get(RequestContextHolder.currentRequestAttributes().getSessionId());
        if (userId == -1)
            return "redirect:/error";

        List<HistoryDto> history = currencyService.getHistoryByUser(userId);

        model.addAttribute("converterdto", new ConverterDto());
        model.addAttribute("historyDto", history);
        return "convert";
    }

    /**
     * Конвертация валют
     *
     * @param converterDto данные конвертации
     */
    @PostMapping("/convert")
    public String convertResult(
            Model model,
            @ModelAttribute("converterdto") ConverterDto converterDto
    ){
        int userId = UserService.usersCache.get(RequestContextHolder.currentRequestAttributes().getSessionId());
        if (userId == -1)
            return "redirect:/error";

        List<HistoryDto> history = currencyService.getHistoryByUser(userId);

        String result = currencyService.calculate(
                converterDto.getCurr1(), converterDto.getCurr2(), Double.valueOf(converterDto.getCurr1value()), userId
        );

        model.addAttribute("converterdto", new ConverterDto(
                converterDto.getCurr1(), converterDto.getCurr2(), converterDto.getCurr1value(), result
        ));

        model.addAttribute("historyDto", history);
        return "convert";
    }

    /**
     * Страница ошибки
     */
    @GetMapping("/error")
    public String error(Model model){
        model.addAttribute("person", new Person());
        return "error";
    }

    /**
     * Страница авторизации
     */
    @GetMapping("/login")
    public String welcome(Model model){
        model.addAttribute("person", new Person());
        return "login";
    }

    /**
     * Авторизация пользователя
     *
     * @param person заполненный пользователь
     * @return страницу конвертации в случае успеха, либо страница ошибки в случае неудачи
     */
    @PostMapping("/login")
    public String login(@ModelAttribute("person") Person person){
       int userId = profileRepository.getUser(
               person.getLogin(), DigestUtils.md5DigestAsHex(person.getPassword().getBytes()).toUpperCase()
       );

       UserService.usersCache.put(RequestContextHolder.currentRequestAttributes().getSessionId(), userId);

       if(userId > 0)
           return "redirect:/convert";
       else {
           return "redirect:/error";
       }
    }

    /**
     * Страница регистрации
     */
    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("person", new Person());

        return "registration";
    }

    /**
     * Регистрация
     *
     * @param person заполненный пользователь
     * @return страница авторизации
     */
    @PostMapping("/registration")
    public String registration(@ModelAttribute("person") Person person){
        profileRepository.addUser(person.getLogin(), person.getPassword());

        return "login";
    }
}
