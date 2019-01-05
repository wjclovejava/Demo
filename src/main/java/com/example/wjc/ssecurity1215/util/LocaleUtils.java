package com.example.wjc.ssecurity1215.util;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * @author ZhangZhiHao 2018/6/26 15:56
 */
public abstract class LocaleUtils {

    public static String getLanguageAndCountry() {
        Locale locale = LocaleContextHolder.getLocale();
        return getLanguageAndCountry(locale);
    }

    public static String getLanguageAndCountry(Locale locale) {
        if (locale == null) {
            locale = LocaleContextHolder.getLocale();
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        return language + "_" + country;
    }
}
