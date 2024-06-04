package com.chess4math.bank_management_system_bank_service.exceptions;

public class BankNotFoundException extends RuntimeException{
    public BankNotFoundException(String message) {
        super(message);
    }
}
