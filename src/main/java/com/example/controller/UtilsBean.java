package com.example.controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static final String DATE_PATTERN = "yyyy-MM-dd";
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

    public static String customFormatDate(Date date) {
	    if (date != null) {
	        DateFormat format = new SimpleDateFormat(DATE_PATTERN);
	        return format.format(date);
	    }
	    return "";
    }


}
