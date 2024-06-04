package com.chess4math.bank_management_system_bank_service.enums;

import com.chess4math.bank_management_system_bank_service.exceptions.AppRoleNotFoundException;

public enum Roles {

    ADMIN("admin"),
    SUPER_ADMIN("supper_admin");

    private String value;

    Roles(String value) {
        this.value = value;
    }

    public static Roles fromString(final String value) {
        for (Roles role : Roles.values()){
           if (role.name().equalsIgnoreCase(value))
               return role;
        }
        throw new AppRoleNotFoundException(String.format("Role: %s was not found", value));
    }
}
