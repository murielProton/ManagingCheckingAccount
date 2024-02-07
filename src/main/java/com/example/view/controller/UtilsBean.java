package com.example.view.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Component
@Named
@ViewScoped
@Slf4j
public class UtilsBean implements Serializable {

    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final String TIME_ZONE = "Europe/Paris";

    public static final String CURRENCY_PATTERN = "#,##0.00 ¤";
    public static final String CURRENCY_SYMBOL = "€";
    public static final String LOCALE_COUNTRY ="fr_FR";
    public static final String CURRENCY_CODE ="EUR";




    public String getDatePattern() {
        return DATE_PATTERN;
    }
    public String getTimeZone() {
        return DATE_PATTERN;
    }

    public String getCurrencyPattern(){
        return CURRENCY_PATTERN;
    }
    public String getCurrencySymbol(){
        return CURRENCY_SYMBOL;
    }

    public String getCurrencyCode(){
        return CURRENCY_CODE;
    }
    public String getLocaleCountry(){
        return LOCALE_COUNTRY;
    }

    public static String customFormatDate(LocalDate date) {
	    if (date != null) {
            return date.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
	    }
	    return "";
    }
    public static  List<String> listOfMonth() {
	    return Arrays.asList("Janvier",
                                    "Février",
                                    "Mars",
                                    "Avril",
                                    "Mai",
                                    "Juin",
                                    "Juillet",
                                    "Août",
                                    "Septembre",
                                    "Octobre",
                                    "Novembre",
                                    "Décembre",
                                    "TOTAL",
                                    "MOYENNE");
    }

}
