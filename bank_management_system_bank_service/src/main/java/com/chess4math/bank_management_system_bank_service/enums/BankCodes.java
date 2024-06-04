package com.chess4math.bank_management_system_bank_service.enums;

import com.chess4math.bank_management_system_bank_service.exceptions.BankNotFoundException;

public enum BankCodes {

    JPMC("12345"),
    FRB("67891");

    private String value;

    BankCodes(String value) {
        this.value = value;
    }

    public static BankCodes fromString(final String value) {
        for (BankCodes code : BankCodes.values()){
           if (code.name().equalsIgnoreCase(value))
               return code;
        }
        throw new BankNotFoundException(String.format("Role: %s was not found", value));
    }

}
