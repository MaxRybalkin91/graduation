package ru.topjava.graduation.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageUtil {

    @Autowired
    private MessageSource messageSource;

    public String getExistedUserName() {
        return messageSource.getMessage("user.existedName", null, LocaleContextHolder.getLocale());
    }
}
