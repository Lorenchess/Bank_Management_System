package com.chess4math.bank_management_system_bank_service.advice;

import com.chess4math.bank_management_system_bank_service.exceptions.AppRoleNotFoundException;
import com.chess4math.bank_management_system_bank_service.exceptions.BankNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private String KEY = "Error: ";

    private <T extends Exception>Map<String, String> errorMapHandler(T exception) {
        Map<String, String>errorMap = new HashMap<>();
        errorMap.put(KEY, exception.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AppRoleNotFoundException.class)
    public Map<String, String> handleAppRolesNotFoundException(AppRoleNotFoundException exception) {
        return errorMapHandler(exception);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BankNotFoundException.class)
    public Map<String, String> handleBankNotFoundException(BankNotFoundException exception) {
        return errorMapHandler(exception);
    }


}
